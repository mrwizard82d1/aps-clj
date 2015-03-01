(ns trading.contract-test
  (:require [clojure.test :refer :all]
            [accountability.party :as ap]
            [trading.contract :as tc]
            [trading.instrument :as ti]
            [clojurewerkz.money.amounts :as ma]
            [clojurewerkz.money.currencies :as mc]))

(deftest ctor-test
  (testing "Given counterparty, instrument, amount, and price."
    (let [counterparty (ap/make)
          instrument (ti/make)
          amount 31
          price (ma/amount-of mc/USD 4.15)
          cut (tc/make counterparty instrument amount price)]
      (testing "When create contract between host and counterparty"
        (is (= counterparty (:counterparty cut)))
        (is (= instrument (:instrument cut)))
        (is (= amount (:amount cut)))
        (is (= price (:price cut)))))))
