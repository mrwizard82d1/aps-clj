(ns trading.contract)

(defn- make [counterparty instrument amount price]
  {:counterparty counterparty
   :instrument instrument
   :amount amount
   :price price})

(defn make-long [counterparty instrument amount price]
  (-> (make counterparty instrument amount price)
      (assoc :position :long)))

(defn make-short [counterparty instrument amount price]
  (-> (make counterparty instrument amount price)
      (assoc :position :short)))

(defn primary-party [contract]
  (get :counterparty contract :this-organization))

(defn counterparty [contract]
      (:counterparty contract))


