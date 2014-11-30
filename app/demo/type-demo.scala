package demo

case class UserId(value: Long)
case class ProductId(value: Long)

case class UserA(id: UserId)
case class ProductA(id: ProductId)

case class UserB(id: Long)
case class ProductB(id: Long)


object Demo {

	val uidA = UserId(1234)
	val pidA = ProductId(5678)

	val uidB = 1234
	val pidB = 5678

	// val userA = UserA(pidA) // type mismatch
	// val productA = ProductA(uidA) // type mismatch

	val userB = UserB(pidB) // legal
	val productB = ProductB(uidB) // legal
}