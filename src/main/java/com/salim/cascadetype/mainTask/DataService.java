package com.salim.cascadetype.mainTask;

import com.salim.cascadetype.mainTask.repositories.GroupRepository;
import com.salim.cascadetype.mainTask.repositories.PersonRepository;
import com.salim.cascadetype.mainTask.repositories.StringRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class DataService {

    @Autowired
    private StringRepository stringRepository;

    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private PersonRepository personRepository;

    public void saveString(String value) {
        stringRepository.save(new StringWrapper(value));
    }

    public void savePerson(Person person) {
        personRepository.save(person);
    }

    public void saveGroup(String groupName, Set<Person> people) {
        Group group = new Group(groupName, people);
        groupRepository.save(group);
    }

    public List<StringWrapper> getAllStrings() {
        return stringRepository.findAll();
    }

    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }

    public List<Group> getAllGroups() {
        return groupRepository.findAll();
    }
}
