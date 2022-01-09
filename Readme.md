### **REDIS-IMPLEMENTATION**  
Let's get started mates
[REDIS-DOCUMENTATION](https://redis.io/documentation)  
REDIS stores data in <KEY,VALUE> format
REDIS supports various data structures as value : 
- strings 
- hashes
- lists
- [sorted] sets
- bitmaps...

Add this dependency to use REDIS <br /> `<dependency>
<groupId>org.springframework.boot</groupId>
<artifactId>spring-boot-starter-data-redis</artifactId>
</dependency>`

By adding the above dependencies and the `@EnableCaching` annotation, Spring Boot will auto-configure 
a RedisCacheManager with default cache configuration. 

To enable the caching behavior, we add the Spring's @Cacheable annotation in some of implemented endpoints.<br />
As mentionned in the code `@Cacheable(value="v_value", key="#v_key")`, we can check it out redis command line using `keys *`. As a result, we get `v_value:v_key`. <br />
We can add conditions on our request fields by adding `@Cacheable(value="v_value", key="#v_key", unless="condition")`