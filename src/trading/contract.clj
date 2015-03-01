(ns trading.contract)

(defn make [counterparty instrument amount price]
  {:counterparty counterparty
   :instrument instrument
   :amount amount
   :price price})

(defn counterparty [contract]
      (:counterparty contract))


