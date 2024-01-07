package com.example

import com.example.models.Ingredients
import com.example.models.OwnBeers
import org.flywaydb.core.Flyway
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.StdOutSqlLogger
import org.jetbrains.exposed.sql.addLogger
import org.jetbrains.exposed.sql.deleteAll
import org.jetbrains.exposed.sql.transactions.experimental.suspendedTransactionAsync
import org.jetbrains.exposed.sql.transactions.transaction

fun initDB() {
    val uri = System.getenv("DB_URI")
    val pass = System.getenv("DB_PASSWORD")
    val username = System.getenv("DB_USER")
    Database.connect(
        "jdbc:postgresql://$uri",
        driver = "org.postgresql.Driver",
        user = username,
        password = pass
    )
    transaction {
        addLogger(StdOutSqlLogger)
    }
    Flyway.configure().dataSource("jdbc:postgresql://$uri", username, pass).load().migrate()
}

suspend fun resetDB() {
    suspendedTransactionAsync {
        Ingredients.deleteAll()
        OwnBeers.deleteAll()
    }.await()
}
