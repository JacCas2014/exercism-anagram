(ns anagram-test
  (:require [clojure.test :refer :all]
            [midje.sweet :refer :all]
            [anagram :refer :all]))

(fact "no-matches"
      (anagrams-for "diaper" ["hello" "world" "zombies" "pants"]) => [])

(future-fact "detect-simple-anagram"
      (anagrams-for "ant" ["tan" "stand" "at"]) => ["tan"])

(future-fact "does-not-confuse-different-duplicates"
      (anagrams-for "galea" ["eagle"]) => [])

(future-fact "eliminate-anagram-subsets"
      (anagrams-for "good" ["dog" "goody"]) => [])

(future-fact "detect-anagram"
      (anagrams-for "listen" ["enlists" "google" "inlets" "banana"]) => ["inlets"])

(future-fact "multiple-anagrams"
      (anagrams-for "allergy" ["gallery" "ballerina" "regally" "clergy" "largely" "leading"]) => ["gallery" "regally" "largely"])

(future-fact "case-insensitive-anagrams"
      (anagrams-for "Orchestra" ["cashregister" "Carthorse" "radishes"]) => ["Carthorse"])

(future-fact "word-is-not-own-anagram"
      (anagrams-for "banana" ["banana"]) => [])

(future-fact "capital-word-is-not-own-anagram"
      (anagrams-for "BANANA" ["banana"]) => [])

(run-tests)
