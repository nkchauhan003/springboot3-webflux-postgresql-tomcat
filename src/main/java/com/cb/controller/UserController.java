package com.cb.controller;


import com.cb.dto.UserDto;
import com.cb.model.User;
import com.cb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/")
    Mono<User> create(@RequestBody Mono<UserDto> userDto) {
        return userService.create(userDto);
    }

    @GetMapping("/{userId}")
    Mono<ResponseEntity<User>> retrieve(@PathVariable int userId) {
        return userService.retrieve(userId)
                .map(ResponseEntity::ok).defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @PutMapping("/{userId}")
    Mono<ResponseEntity<User>> update(@PathVariable int userId, @RequestBody Mono<UserDto> userDto) {
        return userService.update(userId, userDto).map(ResponseEntity::ok).defaultIfEmpty(
                ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{userId}")
    Mono<Void> delete(@PathVariable int userId) {
        return userService.delete(userId);
    }

    @GetMapping("/")
    Flux<User> list() {
        return userService.list();
    }

    /*
    * Only Real Usage of
    * */
    @GetMapping(value = "/e2e-reactive", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    Flux<User> e2eReactiveTest() {
        return Flux.range(1, 10)
                .doOnNext(i -> {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                })
                .doOnNext(i -> System.out.println("number: " + i))
                .map(i -> new User(i, "FirstName_" + i, "LastName_" + i));
    }
}
