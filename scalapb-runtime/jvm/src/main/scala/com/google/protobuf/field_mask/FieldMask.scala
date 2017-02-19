// Generated by the Scala Plugin for the Protocol Buffer Compiler.
// Do not edit!
//
// Protofile syntax: PROTO3

package com.google.protobuf.field_mask

import scala.collection.JavaConverters._

/** `FieldMask` represents a set of symbolic field paths, for example:
  *
  *     paths: "f.a"
  *     paths: "f.b.d"
  *
  * Here `f` represents a field in some root message, `a` and `b`
  * fields in the message found in `f`, and `d` a field found in the
  * message in `f.b`.
  *
  * Field masks are used to specify a subset of fields that should be
  * returned by a get operation or modified by an update operation.
  * Field masks also have a custom JSON encoding (see below).
  *
  * # Field Masks in Projections
  *
  * When used in the context of a projection, a response message or
  * sub-message is filtered by the API to only contain those fields as
  * specified in the mask. For example, if the mask in the previous
  * example is applied to a response message as follows:
  *
  *     f {
  *       a : 22
  *       b {
  *         d : 1
  *         x : 2
  *       }
  *       y : 13
  *     }
  *     z: 8
  *
  * The result will not contain specific values for fields x,y and z
  * (their value will be set to the default, and omitted in proto text
  * output):
  *
  *
  *     f {
  *       a : 22
  *       b {
  *         d : 1
  *       }
  *     }
  *
  * A repeated field is not allowed except at the last position of a
  * field mask.
  *
  * If a FieldMask object is not present in a get operation, the
  * operation applies to all fields (as if a FieldMask of all fields
  * had been specified).
  *
  * Note that a field mask does not necessarily apply to the
  * top-level response message. In case of a REST get operation, the
  * field mask applies directly to the response, but in case of a REST
  * list operation, the mask instead applies to each individual message
  * in the returned resource list. In case of a REST custom method,
  * other definitions may be used. Where the mask applies will be
  * clearly documented together with its declaration in the API.  In
  * any case, the effect on the returned resource/resources is required
  * behavior for APIs.
  *
  * # Field Masks in Update Operations
  *
  * A field mask in update operations specifies which fields of the
  * targeted resource are going to be updated. The API is required
  * to only change the values of the fields as specified in the mask
  * and leave the others untouched. If a resource is passed in to
  * describe the updated values, the API ignores the values of all
  * fields not covered by the mask.
  *
  * If a repeated field is specified for an update operation, the existing
  * repeated values in the target resource will be overwritten by the new values.
  * Note that a repeated field is only allowed in the last position of a field
  * mask.
  *
  * If a sub-message is specified in the last position of the field mask for an
  * update operation, then the existing sub-message in the target resource is
  * overwritten. Given the target message:
  *
  *     f {
  *       b {
  *         d : 1
  *         x : 2
  *       }
  *       c : 1
  *     }
  *
  * And an update message:
  *
  *     f {
  *       b {
  *         d : 10
  *       }
  *     }
  *
  * then if the field mask is:
  *
  *  paths: "f.b"
  *
  * then the result will be:
  *
  *     f {
  *       b {
  *         d : 10
  *       }
  *       c : 1
  *     }
  *
  * However, if the update mask was:
  *
  *  paths: "f.b.d"
  *
  * then the result would be:
  *
  *     f {
  *       b {
  *         d : 10
  *         x : 2
  *       }
  *       c : 1
  *     }
  *
  * In order to reset a field's value to the default, the field must
  * be in the mask and set to the default value in the provided resource.
  * Hence, in order to reset all fields of a resource, provide a default
  * instance of the resource and set all fields in the mask, or do
  * not provide a mask as described below.
  *
  * If a field mask is not present on update, the operation applies to
  * all fields (as if a field mask of all fields has been specified).
  * Note that in the presence of schema evolution, this may mean that
  * fields the client does not know and has therefore not filled into
  * the request will be reset to their default. If this is unwanted
  * behavior, a specific service may require a client to always specify
  * a field mask, producing an error if not.
  *
  * As with get operations, the location of the resource which
  * describes the updated values in the request message depends on the
  * operation kind. In any case, the effect of the field mask is
  * required to be honored by the API.
  *
  * ## Considerations for HTTP REST
  *
  * The HTTP kind of an update operation which uses a field mask must
  * be set to PATCH instead of PUT in order to satisfy HTTP semantics
  * (PUT must only be used for full updates).
  *
  * # JSON Encoding of Field Masks
  *
  * In JSON, a field mask is encoded as a single string where paths are
  * separated by a comma. Fields name in each path are converted
  * to/from lower-camel naming conventions.
  *
  * As an example, consider the following message declarations:
  *
  *     message Profile {
  *       User user = 1;
  *       Photo photo = 2;
  *     }
  *     message User {
  *       string display_name = 1;
  *       string address = 2;
  *     }
  *
  * In proto a field mask for `Profile` may look as such:
  *
  *     mask {
  *       paths: "user.display_name"
  *       paths: "photo"
  *     }
  *
  * In JSON, the same mask is represented as below:
  *
  *     {
  *       mask: "user.displayName,photo"
  *     }
  *
  * # Field Masks and Oneof Fields
  *
  * Field masks treat fields in oneofs just as regular fields. Consider the
  * following message:
  *
  *     message SampleMessage {
  *       oneof test_oneof {
  *         string name = 4;
  *         SubMessage sub_message = 9;
  *       }
  *     }
  *
  * The field mask can be:
  *
  *     mask {
  *       paths: "name"
  *     }
  *
  * Or:
  *
  *     mask {
  *       paths: "sub_message"
  *     }
  *
  * Note that oneof type names ("test_oneof" in this case) cannot be used in
  * paths.
  *
  * @param paths
  *   The set of field mask paths.
  */
@SerialVersionUID(0L)
final case class FieldMask(
    paths: _root_.scala.collection.Seq[String] = _root_.scala.collection.Seq.empty
    ) extends com.trueaccord.scalapb.GeneratedMessage with com.trueaccord.scalapb.Message[FieldMask] with com.trueaccord.lenses.Updatable[FieldMask] {
    @transient
    private[this] var __serializedSizeCachedValue: Int = 0
    private[this] def __computeSerializedValue(): Int = {
      var __size = 0
      paths.foreach(paths => __size += _root_.com.google.protobuf.CodedOutputStream.computeStringSize(1, paths))
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
      paths.foreach { __v =>
        _output__.writeString(1, __v)
      };
    }
    def mergeFrom(`_input__`: _root_.com.google.protobuf.CodedInputStream): com.google.protobuf.field_mask.FieldMask = {
      val __paths = (_root_.scala.collection.immutable.Vector.newBuilder[String] ++= this.paths)
      var _done__ = false
      while (!_done__) {
        val _tag__ = _input__.readTag()
        _tag__ match {
          case 0 => _done__ = true
          case 10 =>
            __paths += _input__.readString()
          case tag => _input__.skipField(tag)
        }
      }
      com.google.protobuf.field_mask.FieldMask(
          paths = __paths.result()
      )
    }
    def clearPaths = copy(paths = _root_.scala.collection.Seq.empty)
    def addPaths(__vs: String*): FieldMask = addAllPaths(__vs)
    def addAllPaths(__vs: TraversableOnce[String]): FieldMask = copy(paths = paths ++ __vs)
    def withPaths(__v: _root_.scala.collection.Seq[String]): FieldMask = copy(paths = __v)
    def getFieldByNumber(__fieldNumber: Int): scala.Any = {
      __fieldNumber match {
        case 1 => paths
      }
    }
    def getField(__field: _root_.scalapb.descriptors.FieldDescriptor): _root_.scalapb.descriptors.PValue = {
      require(__field.containingMessage eq companion.scalaDescriptor)
      __field.number match {
        case 1 => _root_.scalapb.descriptors.PRepeated(paths.map(_root_.scalapb.descriptors.PString(_))(_root_.scala.collection.breakOut))
      }
    }
    override def toString: String = _root_.com.trueaccord.scalapb.TextFormat.printToUnicodeString(this)
    def companion = com.google.protobuf.field_mask.FieldMask
}

object FieldMask extends com.trueaccord.scalapb.GeneratedMessageCompanion[com.google.protobuf.field_mask.FieldMask] with com.trueaccord.scalapb.JavaProtoSupport[com.google.protobuf.field_mask.FieldMask, com.google.protobuf.FieldMask] {
  implicit def messageCompanion: com.trueaccord.scalapb.GeneratedMessageCompanion[com.google.protobuf.field_mask.FieldMask] with com.trueaccord.scalapb.JavaProtoSupport[com.google.protobuf.field_mask.FieldMask, com.google.protobuf.FieldMask] = this
  def toJavaProto(scalaPbSource: com.google.protobuf.field_mask.FieldMask): com.google.protobuf.FieldMask = {
    val javaPbOut = com.google.protobuf.FieldMask.newBuilder
    javaPbOut.addAllPaths(scalaPbSource.paths.asJava)
    javaPbOut.build
  }
  def fromJavaProto(javaPbSource: com.google.protobuf.FieldMask): com.google.protobuf.field_mask.FieldMask = com.google.protobuf.field_mask.FieldMask(
    paths = javaPbSource.getPathsList.asScala.map(_root_.scala.Predef.identity)(_root_.scala.collection.breakOut)
  )
  def fromFieldsMap(__fieldsMap: scala.collection.immutable.Map[_root_.com.google.protobuf.Descriptors.FieldDescriptor, scala.Any]): com.google.protobuf.field_mask.FieldMask = {
    require(__fieldsMap.keys.forall(_.getContainingType() == javaDescriptor), "FieldDescriptor does not match message type.")
    val __fields = javaDescriptor.getFields
    com.google.protobuf.field_mask.FieldMask(
      __fieldsMap.getOrElse(__fields.get(0), Nil).asInstanceOf[_root_.scala.collection.Seq[String]]
    )
  }
  implicit def messageReads: _root_.scalapb.descriptors.Reads[com.google.protobuf.field_mask.FieldMask] = _root_.scalapb.descriptors.Reads(_ match {
    case _root_.scalapb.descriptors.PMessage(__fieldsMap) =>
      require(__fieldsMap.keys.forall(_.containingMessage == scalaDescriptor), "FieldDescriptor does not match message type.")
      com.google.protobuf.field_mask.FieldMask(
        __fieldsMap.get(scalaDescriptor.findFieldByNumber(1).get).map(_.as[_root_.scala.collection.Seq[String]]).getOrElse(_root_.scala.collection.Seq.empty)
      )
    case _ => throw new RuntimeException("Expected PMessage")
  })
  def javaDescriptor: _root_.com.google.protobuf.Descriptors.Descriptor = FieldMaskProto.javaDescriptor.getMessageTypes.get(0)
  def scalaDescriptor: _root_.scalapb.descriptors.Descriptor = FieldMaskProto.scalaDescriptor.messages(0)
  def messageCompanionForFieldNumber(__fieldNumber: Int): _root_.com.trueaccord.scalapb.GeneratedMessageCompanion[_] = throw new MatchError(__fieldNumber)
  def enumCompanionForFieldNumber(__fieldNumber: Int): _root_.com.trueaccord.scalapb.GeneratedEnumCompanion[_] = throw new MatchError(__fieldNumber)
  lazy val defaultInstance = com.google.protobuf.field_mask.FieldMask(
  )
  implicit class FieldMaskLens[UpperPB](_l: _root_.com.trueaccord.lenses.Lens[UpperPB, com.google.protobuf.field_mask.FieldMask]) extends _root_.com.trueaccord.lenses.ObjectLens[UpperPB, com.google.protobuf.field_mask.FieldMask](_l) {
    def paths: _root_.com.trueaccord.lenses.Lens[UpperPB, _root_.scala.collection.Seq[String]] = field(_.paths)((c_, f_) => c_.copy(paths = f_))
  }
  final val PATHS_FIELD_NUMBER = 1
}
