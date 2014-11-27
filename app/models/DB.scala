package models

import sorm._

object DB extends Instance(entities = Set(
    Entity[Offer](),
    Entity[Demand]()
    ), url = "jdbc:h2:mem:test")