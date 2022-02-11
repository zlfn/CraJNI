package com.iroom.crajni

class Native {
    companion object
    {
        @JvmStatic
        external fun getPrimeFactorsRust(num: Long) : String

        @JvmStatic
        external fun getPrimeFactorsRustLib(num: Long) : String

        @JvmStatic
        external fun getPrimeFactorsRustDouble(num:Long) : String

        @JvmStatic
        external fun recall(num: Long) : String

        fun getPrimeFactors(number: Long): String {
            var number = number
            //set not Allowed Duplicate element
            val setPrimeFactors: MutableSet<Long> = HashSet()
            var i :Long = 2
            while (i <= number) {
                if (number % i == 0L) {
                    // Add prime factor in Hash Set
                    setPrimeFactors.add(i)
                    number /= i
                    i--
                }
                i++
            }
            return setPrimeFactors.toString()
        }
    }
}