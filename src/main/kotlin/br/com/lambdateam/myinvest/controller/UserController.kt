package br.com.lambdateam.myinvest.controller

import br.com.lambdateam.myinvest.model.UserModel
import br.com.lambdateam.myinvest.model.response.PatchUser
import br.com.lambdateam.myinvest.repository.UserRepository
import org.apache.catalina.User
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.server.ResponseStatusException

@Service
@RestController
@RequestMapping("/users", produces = [MediaType.APPLICATION_JSON_VALUE])
class UserController(val userRepository: UserRepository) {

    @GetMapping
    fun listUsers() = userRepository.findAllByOrderByIdDesc()

    @GetMapping("/{id}")
    fun findUserById(@PathVariable("id") id: Long) = userRepository.findById(id).orElseThrow { ResponseStatusException(HttpStatus.NOT_FOUND) }

    @GetMapping("/byUserName")
    fun getUserByEmail(email: String) = userRepository.findAllByEmailEqualsIgnoreCase(email)

    @PostMapping
    fun createUser(@RequestBody user: UserModel) = userRepository.save(user)

    @PutMapping("/{id}")
    fun fullUpdateUser(@PathVariable("id") id: Long, @RequestBody user: UserModel) : UserModel {
        val foundUser = findUserById(id)
        val copyUser = foundUser.copy(
            userName = user.userName,
            email = user.email,
            password = user.password
        )
        return userRepository.save(copyUser)
    }

    @PatchMapping("/{id}")
    fun incrementalUpdateUser(@PathVariable("id") id: Long, @RequestBody user: PatchUser): UserModel {
        val foundUser = findUserById(id)
        val newUser = foundUser.copy(
            userName = user.userName ?: foundUser.userName,
            email = user.email ?: foundUser.email,
            password = user.password ?: foundUser.password
        )
        return userRepository.save(newUser)
    }

    @DeleteMapping("/{id}")
    fun deleteUser(@PathVariable("id") id: Long) = userRepository.delete(findUserById(id))
}