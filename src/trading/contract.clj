(ns trading.contract)

(defn make-long [counterparty instrument amount price]
  {:counterparty counterparty
   :instrument instrument
   :amount amount
   :price price
   :position :long})

(defn make-short [counterparty instrument amount price]
  {:counterparty counterparty
   :instrument instrument
   :amount amount
   :price price
   :position :short})

(defn primary-party [contract]
  (get :counterparty contract :this-organization))

(defn counterparty [contract]
      (:counterparty contract))


