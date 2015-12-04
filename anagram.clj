(ns anagram
 (:require [clojure.string :as str]))

(defn word-is-not-an-exact-match? [word possible-anagram]
 (not= (str/lower-case word) (str/lower-case possible-anagram)))

(defn word-is-a-match? [word possible-anagram]
 (= (sort (str/lower-case word)) (sort (str/lower-case possible-anagram))))

(defn word-is-an-anagram? [word possible-anagram]
 (and (word-is-not-an-exact-match? word possible-anagram)
      (word-is-a-match? word possible-anagram)))

(defn anagrams-for [word possible-anagrams]
 (filter (partial word-is-an-anagram? word) possible-anagrams))
