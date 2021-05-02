package springbootignite.com.service;



import springbootignite.com.model.Person2;

import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteCache;
import org.apache.ignite.IgniteDataStreamer;
import org.apache.ignite.configuration.CacheConfiguration;
import org.apache.ignite.lang.IgniteFuture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Service
public class PersonService {

	
    @Autowired
    private Ignite igniteInstance;
    
    @Autowired
    private CacheConfiguration[] cacheconfigs;



    public Person2 getPerson(long id){
    	IgniteCache personCache = igniteInstance.getOrCreateCache(cacheconfigs[0]);
        return (Person2)personCache.get(id);
    }




    /**
     * Fills the repository in with some sample data.
     */
    @PostConstruct
    private  void populateRepository() {

        IgniteCache personCache = igniteInstance.getOrCreateCache(cacheconfigs[0]);

        

        Person2 p1 = new Person2(1L,"A","B",30);
        personCache.put(p1.getId(), p1);
        System.out.println("Added all users...");
  
    }
}