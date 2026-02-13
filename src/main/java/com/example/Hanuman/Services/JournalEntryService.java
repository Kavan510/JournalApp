package com.example.Hanuman.Services;

//includes business logic


import com.example.Hanuman.entity.JournalEntry;
import com.example.Hanuman.entity.User;
import com.example.Hanuman.repository.JournalEntryRepository;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@Component
public class JournalEntryService {
    @Autowired
    private JournalEntryRepository journalEntryRepository;
@Autowired
private UserEntryService userEntryService;


@Transactional
    public void saveEntry(JournalEntry journalEntry, String userName){
        try{
        User user = userEntryService.findByuserName(userName);
        journalEntry.setDate(LocalDateTime.now());
        JournalEntry saved =  journalEntryRepository.save(journalEntry);
        user.getJournalEntries().add(saved);
        userEntryService.addUser(user);
        }
        catch (Exception e) {
            System.out.println(e);
            throw new RuntimeException("An error occured while saving the entry"+e);
        }
    }

    public void saveEntry(JournalEntry journalEntry){

        journalEntryRepository.save(journalEntry);
    }

    public List<JournalEntry> getAll(){
        return journalEntryRepository.findAll();
    }

    public Optional<JournalEntry> findJournalEntryById(ObjectId id){
        return journalEntryRepository.findById(id);
    }



    public void deleteById(ObjectId id, String userName){
        try{

    User user = userEntryService.findByuserName(userName);
    boolean removed = user.getJournalEntries().removeIf(x-> x.getId().equals(id));
    if(removed){

        userEntryService.addUser(user);
        journalEntryRepository.deleteById(id);
    }
    }
        catch (Exception e) {
            throw new RuntimeException("An error occured while deleting the entry"+e);
        }

        }

//    public List<JournalEntry> findByUserName(String userName)
//    {
//
//    }

}
