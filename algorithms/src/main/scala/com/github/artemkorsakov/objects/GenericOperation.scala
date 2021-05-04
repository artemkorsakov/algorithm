package com.github.artemkorsakov.objects

object GenericOperation {
  def zeroT[T](t1: T): T = t1 match {
    case _: Int        => Default.value[Int].asInstanceOf[T]
    case _: Long       => Default.value[Long].asInstanceOf[T]
    case _: Double     => Default.value[Double].asInstanceOf[T]
    case _: BigInt     => Default.value[BigInt].asInstanceOf[T]
    case _: BigDecimal => Default.value[BigDecimal].asInstanceOf[T]
    case _             => Default.value[T]
  }

  def oneT[T](t1: T): T = t1 match {
    case _: Int        => 1.asInstanceOf[T]
    case _: Long       => 1L.asInstanceOf[T]
    case _: Double     => 1.0.asInstanceOf[T]
    case _: BigInt     => BigInt(1).asInstanceOf[T]
    case _: BigDecimal => BigDecimal(1.0).asInstanceOf[T]
    case _             => Default.value[T]
  }

  def addT[T](t1: T, t2: T): T = (t1, t2) match {
    case (v1: Int, v2: Int)               => (v1 + v2).asInstanceOf[T]
    case (v1: Long, v2: Long)             => (v1 + v2).asInstanceOf[T]
    case (v1: Double, v2: Double)         => (v1 + v2).asInstanceOf[T]
    case (v1: BigInt, v2: BigInt)         => (v1 + v2).asInstanceOf[T]
    case (v1: BigDecimal, v2: BigDecimal) => (v1 + v2).asInstanceOf[T]
    case _                                => Default.value[T]
  }

  def subT[T](t1: T, t2: T): T = (t1, t2) match {
    case (v1: Int, v2: Int)               => (v1 - v2).asInstanceOf[T]
    case (v1: Long, v2: Long)             => (v1 - v2).asInstanceOf[T]
    case (v1: Double, v2: Double)         => (v1 - v2).asInstanceOf[T]
    case (v1: BigInt, v2: BigInt)         => (v1 - v2).asInstanceOf[T]
    case (v1: BigDecimal, v2: BigDecimal) => (v1 - v2).asInstanceOf[T]
    case _                                => Default.value[T]
  }

  def mulT[T](t1: T, t2: T): T = (t1, t2) match {
    case (v1: Int, v2: Int)               => (v1 * v2).asInstanceOf[T]
    case (v1: Long, v2: Long)             => (v1 * v2).asInstanceOf[T]
    case (v1: Double, v2: Double)         => (v1 * v2).asInstanceOf[T]
    case (v1: BigInt, v2: BigInt)         => (v1 * v2).asInstanceOf[T]
    case (v1: BigDecimal, v2: BigDecimal) => (v1 * v2).asInstanceOf[T]
    case _                                => Default.value[T]
  }

  def modT[T](t1: T, t2: T): T = (t1, t2) match {
    case (v1: Int, v2: Int)               => (((v1 % v2) + v2) % v2).asInstanceOf[T]
    case (v1: Long, v2: Long)             => (((v1 % v2) + v2) % v2).asInstanceOf[T]
    case (v1: Double, v2: Double)         => (((v1 % v2) + v2) % v2).asInstanceOf[T]
    case (v1: BigInt, v2: BigInt)         => (((v1 % v2) + v2) % v2).asInstanceOf[T]
    case (v1: BigDecimal, v2: BigDecimal) => (((v1 % v2) + v2) % v2).asInstanceOf[T]
    case _                                => Default.value[T]
  }

}
