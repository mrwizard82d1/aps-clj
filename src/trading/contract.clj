(ns trading.contract)

(defn make [party instrument amount price]
  {:party party
   :instrument instrument
   :amount amount
   :price price})


