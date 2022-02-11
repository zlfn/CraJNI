package com.iroom.crajni

import com.iroom.crajni.Native.Companion.getPrimeFactors
import com.iroom.crajni.Native.Companion.getPrimeFactorsRust
import com.iroom.crajni.Native.Companion.getPrimeFactorsRustDouble
import com.iroom.crajni.Native.Companion.getPrimeFactorsRustLib
import com.iroom.crajni.Native.Companion.recall
import org.bukkit.Bukkit
import org.bukkit.plugin.java.JavaPlugin

class Crajni : JavaPlugin() {

    companion object
    {
        init {
            System.loadLibrary("rust")
        }
    }
    override fun onEnable() {
        val test:Long = 67463283888005
        var T = System.currentTimeMillis()
        Bukkit.getConsoleSender().sendMessage(getPrimeFactors(test))
        Bukkit.getConsoleSender().sendMessage("Kotlin 직접 구현: " + (System.currentTimeMillis()-T).toString() + "ms 소요");
        T = System.currentTimeMillis()
        Bukkit.getConsoleSender().sendMessage(getPrimeFactorsRust(test))
        Bukkit.getConsoleSender().sendMessage("Rust 직접 구현: " + (System.currentTimeMillis()-T).toString() + "ms 소요");
        T = System.currentTimeMillis()
        Bukkit.getConsoleSender().sendMessage(getPrimeFactorsRustDouble(test))
        Bukkit.getConsoleSender().sendMessage("Rust 직접 구현 2회 돌리기: " + (System.currentTimeMillis()-T).toString() + "ms 소요");
        T = System.currentTimeMillis()
        Bukkit.getConsoleSender().sendMessage(getPrimeFactorsRustLib(test))
        Bukkit.getConsoleSender().sendMessage("Rust 라이브러리 이용: " + (System.currentTimeMillis()-T).toString() + "ms 소요");
        T = System.currentTimeMillis()
        recall(test)
        Bukkit.getConsoleSender().sendMessage("Rust 단순 리턴: " + (System.currentTimeMillis()-T).toString() + "ms 소요");
    }

    override fun onDisable() {
        // Plugin shutdown logic
    }
}