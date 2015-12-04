(ns anagram-test
  (:require [clojure.test :refer :all]
            [midje.sweet :refer :all]
            [anagram :refer :all]))

(fact "no-matches"
      (anagrams-for "diaper" ["hello" "world" "zombies" "pants"]) => [])

(fact "detect-simple-anagram"
      (anagrams-for "ant" ["tan" "stand" "at"]) => ["tan"])

(fact "does-not-confuse-different-duplicates"
      (anagrams-for "galea" ["eagle"]) => [])

(fact "eliminate-anagram-subsets"
      (anagrams-for "good" ["dog" "goody"]) => [])

(fact "detect-anagram"
      (anagrams-for "listen" ["enlists" "google" "inlets" "banana"]) => ["inlets"])

(fact "multiple-anagrams"
      (anagrams-for "allergy" ["gallery" "ballerina" "regally" "clergy" "largely" "leading"]) => ["gallery" "regally" "largely"])

(fact "case-insensitive-anagrams"
      (anagrams-for "Orchestra" ["cashregister" "Carthorse" "radishes"]) => ["Carthorse"])

(fact "word-is-not-own-anagram"
      (anagrams-for "banana" ["banana"]) => [])

(fact "capital-word-is-not-own-anagram"
      (anagrams-for "BANANA" ["banana"]) => [])

(facts "word-is-an-anagram?"
       (fact "returns false when word is an exact match"
             (word-is-an-anagram? "ant" "ant") => falsey)
       (fact "returns true when word is an anagram"
             (word-is-an-anagram? "ant" "tan") => truthy)
       (fact "returns false when word is not an anagram"
             (word-is-an-anagram? "ant" "can") => falsey)
       (fact "returns false when word has an extra letter"
             (word-is-an-anagram? "ant" "ants") => falsey)
       (fact "returns false when word has a letter less"
             (word-is-an-anagram? "ant" "an") => falsey))
