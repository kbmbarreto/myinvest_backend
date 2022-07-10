package br.com.lambdateam.myinvest.controller

import br.com.lambdateam.myinvest.extension.toModel
import br.com.lambdateam.myinvest.extension.toResponse
import br.com.lambdateam.myinvest.extension.toUserModel
import br.com.lambdateam.myinvest.model.UserModel
import br.com.lambdateam.myinvest.model.response.PatchUser
import br.com.lambdateam.myinvest.model.response.PostUser
import br.com.lambdateam.myinvest.model.response.PutUser
import br.com.lambdateam.myinvest.model.response.UserResponse
import br.com.lambdateam.myinvest.repository.UserRepository
import br.com.lambdateam.myinvest.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
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

@RestController
@RequestMapping("users", produces = [MediaType.APPLICATION_JSON_VALUE])
class UserController(val userService: UserService, val userRepository: UserRepository) {

    @GetMapping
    fun listUsers() = userService.findAll().map { it.toResponse() }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): UserResponse {
        return userService.findById(id).toResponse()
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createUser(@RequestBody user: PostUser) {
        userService.createUser(user.toModel())
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun fullUpdateUser(@PathVariable id: Long, @RequestBody user: PutUser) {
        val userSaved = userService.findById(id)
        userService.update(user.toUserModel(userSaved))
    }
}