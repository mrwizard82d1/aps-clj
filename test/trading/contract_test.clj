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
          price (ma/amount-of mc/USD 4.15)]
      (testing "When create long contract (primary party implied)"
        (let [long-cut
              (tc/make-long counterparty instrument amount price)]
          (is (= :this-organization (tc/primary-party long-cut)))
          (is (= counterparty (tc/counterparty long-cut)))
          (is (= instrument (:instrument long-cut)))
          (is (= amount (:amount long-cut)))
          (is (= price (:price long-cut)))
          (is (= :long (:position long-cut)))))
      (testing "When create short contract (primary party implied)"
        (let [short-cut
              (tc/make-short counterparty instrument amount price)]
          (is (= :this-organization (tc/primary-party short-cut)))
          (is (= counterparty (tc/counterparty short-cut)))
          (is (= instrument (:instrument short-cut)))
          (is (= amount (:amount short-cut)))
          (is (= price (:price short-cut)))
          (is (= :short (:position short-cut))))))))
