// Generated by the Scala Plugin for the Protocol Buffer Compiler.
// Do not edit!
//
// Protofile syntax: PROTO3

package com.google.protobuf.`type`



/** Enum value definition.
  *
  * @param name
  *   Enum value name.
  * @param number
  *   Enum value number.
  * @param options
  *   Protocol buffer options.
  */
@SerialVersionUID(0L)
final case class EnumValue(
    name: String = "",
    number: Int = 0,
    options: _root_.scala.collection.Seq[com.google.protobuf.`type`.OptionProto] = _root_.scala.collection.Seq.empty
    ) extends com.trueaccord.scalapb.GeneratedMessage with com.trueaccord.scalapb.Message[EnumValue] with com.trueaccord.lenses.Updatable[EnumValue] {
    @transient
    private[this] var __serializedSizeCachedValue: Int = 0
    private[this] def __computeSerializedValue(): Int = {
      var __size = 0
      if (name != "") { __size += _root_.com.google.protobuf.CodedOutputStream.computeStringSize(1, name) }
      if (number != 0) { __size += _root_.com.google.protobuf.CodedOutputStream.computeInt32Size(2, number) }
      options.foreach(options => __size += 1 + _root_.com.google.protobuf.CodedOutputStream.computeUInt32SizeNoTag(options.serializedSize) + options.serializedSize)
      __size
    }
    final override def serializedSize: Int = {
      var read = __serializedSizeCachedValue
      if (read == 0) {
        read = __computeSerializedValue()
        __serializedSizeCachedValue = read
      }
      read
    }
    def writeTo(`_output__`: _root_.com.google.protobuf.CodedOutputStream): Unit = {
      {
        val __v = name
        if (__v != "") {
          _output__.writeString(1, __v)
        }
      };
      {
        val __v = number
        if (__v != 0) {
          _output__.writeInt32(2, __v)
        }
      };
      options.foreach { __v =>
        _output__.writeTag(3, 2)
        _output__.writeUInt32NoTag(__v.serializedSize)
        __v.writeTo(_output__)
      };
    }
    def mergeFrom(`_input__`: _root_.com.google.protobuf.CodedInputStream): com.google.protobuf.`type`.EnumValue = {
      var __name = this.name
      var __number = this.number
      val __options = (_root_.scala.collection.immutable.Vector.newBuilder[com.google.protobuf.`type`.OptionProto] ++= this.options)
      var _done__ = false
      while (!_done__) {
        val _tag__ = _input__.readTag()
        _tag__ match {
          case 0 => _done__ = true
          case 10 =>
            __name = _input__.readString()
          case 16 =>
            __number = _input__.readInt32()
          case 26 =>
            __options += _root_.com.trueaccord.scalapb.LiteParser.readMessage(_input__, com.google.protobuf.`type`.OptionProto.defaultInstance)
          case tag => _input__.skipField(tag)
        }
      }
      com.google.protobuf.`type`.EnumValue(
          name = __name,
          number = __number,
          options = __options.result()
      )
    }
    def withName(__v: String): EnumValue = copy(name = __v)
    def withNumber(__v: Int): EnumValue = copy(number = __v)
    def clearOptions = copy(options = _root_.scala.collection.Seq.empty)
    def addOptions(__vs: com.google.protobuf.`type`.OptionProto*): EnumValue = addAllOptions(__vs)
    def addAllOptions(__vs: TraversableOnce[com.google.protobuf.`type`.OptionProto]): EnumValue = copy(options = options ++ __vs)
    def withOptions(__v: _root_.scala.collection.Seq[com.google.protobuf.`type`.OptionProto]): EnumValue = copy(options = __v)
    def getFieldByNumber(__fieldNumber: Int): scala.Any = {
      __fieldNumber match {
        case 1 => {
          val __t = name
          if (__t != "") __t else null
        }
        case 2 => {
          val __t = number
          if (__t != 0) __t else null
        }
        case 3 => options
      }
    }
    def getField(__field: _root_.scalapb.descriptors.FieldDescriptor): _root_.scalapb.descriptors.PValue = {
      require(__field.containingMessage eq companion.scalaDescriptor)
      __field.number match {
        case 1 => _root_.scalapb.descriptors.PString(name)
        case 2 => _root_.scalapb.descriptors.PInt(number)
        case 3 => _root_.scalapb.descriptors.PRepeated(options.map(_.toPMessage)(_root_.scala.collection.breakOut))
      }
    }
    override def toString: String = _root_.com.trueaccord.scalapb.TextFormat.printToUnicodeString(this)
    def companion = com.google.protobuf.`type`.EnumValue
}

object EnumValue extends com.trueaccord.scalapb.GeneratedMessageCompanion[com.google.protobuf.`type`.EnumValue] {
  implicit def messageCompanion: com.trueaccord.scalapb.GeneratedMessageCompanion[com.google.protobuf.`type`.EnumValue] = this
  def fromFieldsMap(__fieldsMap: scala.collection.immutable.Map[_root_.com.google.protobuf.Descriptors.FieldDescriptor, scala.Any]): com.google.protobuf.`type`.EnumValue = {
    require(__fieldsMap.keys.forall(_.getContainingType() == javaDescriptor), "FieldDescriptor does not match message type.")
    val __fields = javaDescriptor.getFields
    com.google.protobuf.`type`.EnumValue(
      __fieldsMap.getOrElse(__fields.get(0), "").asInstanceOf[String],
      __fieldsMap.getOrElse(__fields.get(1), 0).asInstanceOf[Int],
      __fieldsMap.getOrElse(__fields.get(2), Nil).asInstanceOf[_root_.scala.collection.Seq[com.google.protobuf.`type`.OptionProto]]
    )
  }
  implicit def messageReads: _root_.scalapb.descriptors.Reads[com.google.protobuf.`type`.EnumValue] = _root_.scalapb.descriptors.Reads(_ match {
    case _root_.scalapb.descriptors.PMessage(__fieldsMap) =>
      require(__fieldsMap.keys.forall(_.containingMessage == scalaDescriptor), "FieldDescriptor does not match message type.")
      com.google.protobuf.`type`.EnumValue(
        __fieldsMap.get(scalaDescriptor.findFieldByNumber(1).get).map(_.as[String]).getOrElse(""),
        __fieldsMap.get(scalaDescriptor.findFieldByNumber(2).get).map(_.as[Int]).getOrElse(0),
        __fieldsMap.get(scalaDescriptor.findFieldByNumber(3).get).map(_.as[_root_.scala.collection.Seq[com.google.protobuf.`type`.OptionProto]]).getOrElse(_root_.scala.collection.Seq.empty)
      )
    case _ => throw new RuntimeException("Expected PMessage")
  })
  def javaDescriptor: _root_.com.google.protobuf.Descriptors.Descriptor = TypeProto.javaDescriptor.getMessageTypes.get(3)
  def scalaDescriptor: _root_.scalapb.descriptors.Descriptor = TypeProto.scalaDescriptor.messages(3)
  def messageCompanionForFieldNumber(__fieldNumber: Int): _root_.com.trueaccord.scalapb.GeneratedMessageCompanion[_] = {
    var __out: _root_.com.trueaccord.scalapb.GeneratedMessageCompanion[_] = null
    __fieldNumber match {
      case 3 => __out = com.google.protobuf.`type`.OptionProto
    }
  __out
  }
  def enumCompanionForFieldNumber(__fieldNumber: Int): _root_.com.trueaccord.scalapb.GeneratedEnumCompanion[_] = throw new MatchError(__fieldNumber)
  lazy val defaultInstance = com.google.protobuf.`type`.EnumValue(
  )
  implicit class EnumValueLens[UpperPB](_l: _root_.com.trueaccord.lenses.Lens[UpperPB, com.google.protobuf.`type`.EnumValue]) extends _root_.com.trueaccord.lenses.ObjectLens[UpperPB, com.google.protobuf.`type`.EnumValue](_l) {
    def name: _root_.com.trueaccord.lenses.Lens[UpperPB, String] = field(_.name)((c_, f_) => c_.copy(name = f_))
    def number: _root_.com.trueaccord.lenses.Lens[UpperPB, Int] = field(_.number)((c_, f_) => c_.copy(number = f_))
    def options: _root_.com.trueaccord.lenses.Lens[UpperPB, _root_.scala.collection.Seq[com.google.protobuf.`type`.OptionProto]] = field(_.options)((c_, f_) => c_.copy(options = f_))
  }
  final val NAME_FIELD_NUMBER = 1
  final val NUMBER_FIELD_NUMBER = 2
  final val OPTIONS_FIELD_NUMBER = 3
}
