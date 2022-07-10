package br.com.lambdateam.myinvest.service

import br.com.lambdateam.myinvest.model.UserModel
import br.com.lambdateam.myinvest.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(private val userRepository: UserRepository) {

    fun findAll() = userRepository.findAll()

    fun findById(id: Long): UserModel {
        return userRepository.findById(id).orElseThrow()
    }

    fun createUser(user: UserModel) {
        userRepository.save(user)
    }
}