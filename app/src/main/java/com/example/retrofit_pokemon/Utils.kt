package com.example.retrofit_pokemon

class Utils {
    var rubros: Map<String, String> = object : MutableMap<String?, String?> {
        override fun size(): Int {
            return 0
        }

        override fun isEmpty(): Boolean {
            return false
        }

        override fun containsKey(key: Any?): Boolean {
            return false
        }

        override fun containsValue(value: Any?): Boolean {
            return false
        }

        override operator fun get(key: Any?): String? {
            return null
        }

        override fun put(key: String, value: String): String? {
            return null
        }

        override fun remove(key: Any?): String? {
            return null
        }

        override fun putAll(m: Map<out String, String>) {}
        override fun clear() {}
        override fun keySet(): Set<String> {
            return null
        }

        override fun values(): Collection<String> {
            return null
        }

        override fun entrySet(): Set<Map.Entry<String, String>> {
            return null
        }
    }
}