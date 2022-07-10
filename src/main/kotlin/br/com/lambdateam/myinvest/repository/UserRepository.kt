package br.com.lambdateam.myinvest.repository

import br.com.lambdateam.myinvest.model.UserModel
import org.springframework.data.jpa.repository.JpaRepository
import java.util.Optional

interface UserRepository: JpaRepository<UserModel, Long> {

    override fun findById(id: Long): Optional<UserModel>

}