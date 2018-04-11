/**
 * Autogenerated by Thrift Compiler (0.11.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.youhaoxi.soa.search.api.thrift;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.11.0)", date = "2018-04-05")
public class MoviePersonDataDto implements org.apache.thrift.TBase<MoviePersonDataDto, MoviePersonDataDto._Fields>, java.io.Serializable, Cloneable, Comparable<MoviePersonDataDto> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("MoviePersonDataDto");

  private static final org.apache.thrift.protocol.TField MOVIE_PERSON_INFO_FIELD_DESC = new org.apache.thrift.protocol.TField("moviePersonInfo", org.apache.thrift.protocol.TType.STRUCT, (short)1);
  private static final org.apache.thrift.protocol.TField STAT_DATA_FIELD_DESC = new org.apache.thrift.protocol.TField("statData", org.apache.thrift.protocol.TType.STRUCT, (short)2);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new MoviePersonDataDtoStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new MoviePersonDataDtoTupleSchemeFactory();

  public MoviePersonInfoVo moviePersonInfo; // optional
  public MoviePersonStatDataVo statData; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    MOVIE_PERSON_INFO((short)1, "moviePersonInfo"),
    STAT_DATA((short)2, "statData");

    private static final java.util.Map<java.lang.String, _Fields> byName = new java.util.HashMap<java.lang.String, _Fields>();

    static {
      for (_Fields field : java.util.EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // MOVIE_PERSON_INFO
          return MOVIE_PERSON_INFO;
        case 2: // STAT_DATA
          return STAT_DATA;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new java.lang.IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(java.lang.String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final java.lang.String _fieldName;

    _Fields(short thriftId, java.lang.String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public java.lang.String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  private static final _Fields optionals[] = {_Fields.MOVIE_PERSON_INFO,_Fields.STAT_DATA};
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.MOVIE_PERSON_INFO, new org.apache.thrift.meta_data.FieldMetaData("moviePersonInfo", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRUCT        , "MoviePersonInfoVo")));
    tmpMap.put(_Fields.STAT_DATA, new org.apache.thrift.meta_data.FieldMetaData("statData", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRUCT        , "MoviePersonStatDataVo")));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(MoviePersonDataDto.class, metaDataMap);
  }

  public MoviePersonDataDto() {
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public MoviePersonDataDto(MoviePersonDataDto other) {
    if (other.isSetMoviePersonInfo()) {
      this.moviePersonInfo = new MoviePersonInfoVo(other.moviePersonInfo);
    }
    if (other.isSetStatData()) {
      this.statData = new MoviePersonStatDataVo(other.statData);
    }
  }

  public MoviePersonDataDto deepCopy() {
    return new MoviePersonDataDto(this);
  }

  @Override
  public void clear() {
    this.moviePersonInfo = null;
    this.statData = null;
  }

  public MoviePersonInfoVo getMoviePersonInfo() {
    return this.moviePersonInfo;
  }

  public MoviePersonDataDto setMoviePersonInfo(MoviePersonInfoVo moviePersonInfo) {
    this.moviePersonInfo = moviePersonInfo;
    return this;
  }

  public void unsetMoviePersonInfo() {
    this.moviePersonInfo = null;
  }

  /** Returns true if field moviePersonInfo is set (has been assigned a value) and false otherwise */
  public boolean isSetMoviePersonInfo() {
    return this.moviePersonInfo != null;
  }

  public void setMoviePersonInfoIsSet(boolean value) {
    if (!value) {
      this.moviePersonInfo = null;
    }
  }

  public MoviePersonStatDataVo getStatData() {
    return this.statData;
  }

  public MoviePersonDataDto setStatData(MoviePersonStatDataVo statData) {
    this.statData = statData;
    return this;
  }

  public void unsetStatData() {
    this.statData = null;
  }

  /** Returns true if field statData is set (has been assigned a value) and false otherwise */
  public boolean isSetStatData() {
    return this.statData != null;
  }

  public void setStatDataIsSet(boolean value) {
    if (!value) {
      this.statData = null;
    }
  }

  public void setFieldValue(_Fields field, java.lang.Object value) {
    switch (field) {
    case MOVIE_PERSON_INFO:
      if (value == null) {
        unsetMoviePersonInfo();
      } else {
        setMoviePersonInfo((MoviePersonInfoVo)value);
      }
      break;

    case STAT_DATA:
      if (value == null) {
        unsetStatData();
      } else {
        setStatData((MoviePersonStatDataVo)value);
      }
      break;

    }
  }

  public java.lang.Object getFieldValue(_Fields field) {
    switch (field) {
    case MOVIE_PERSON_INFO:
      return getMoviePersonInfo();

    case STAT_DATA:
      return getStatData();

    }
    throw new java.lang.IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new java.lang.IllegalArgumentException();
    }

    switch (field) {
    case MOVIE_PERSON_INFO:
      return isSetMoviePersonInfo();
    case STAT_DATA:
      return isSetStatData();
    }
    throw new java.lang.IllegalStateException();
  }

  @Override
  public boolean equals(java.lang.Object that) {
    if (that == null)
      return false;
    if (that instanceof MoviePersonDataDto)
      return this.equals((MoviePersonDataDto)that);
    return false;
  }

  public boolean equals(MoviePersonDataDto that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_moviePersonInfo = true && this.isSetMoviePersonInfo();
    boolean that_present_moviePersonInfo = true && that.isSetMoviePersonInfo();
    if (this_present_moviePersonInfo || that_present_moviePersonInfo) {
      if (!(this_present_moviePersonInfo && that_present_moviePersonInfo))
        return false;
      if (!this.moviePersonInfo.equals(that.moviePersonInfo))
        return false;
    }

    boolean this_present_statData = true && this.isSetStatData();
    boolean that_present_statData = true && that.isSetStatData();
    if (this_present_statData || that_present_statData) {
      if (!(this_present_statData && that_present_statData))
        return false;
      if (!this.statData.equals(that.statData))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + ((isSetMoviePersonInfo()) ? 131071 : 524287);
    if (isSetMoviePersonInfo())
      hashCode = hashCode * 8191 + moviePersonInfo.hashCode();

    hashCode = hashCode * 8191 + ((isSetStatData()) ? 131071 : 524287);
    if (isSetStatData())
      hashCode = hashCode * 8191 + statData.hashCode();

    return hashCode;
  }

  @Override
  public int compareTo(MoviePersonDataDto other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = java.lang.Boolean.valueOf(isSetMoviePersonInfo()).compareTo(other.isSetMoviePersonInfo());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetMoviePersonInfo()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.moviePersonInfo, other.moviePersonInfo);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetStatData()).compareTo(other.isSetStatData());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetStatData()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.statData, other.statData);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    scheme(iprot).read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    scheme(oprot).write(oprot, this);
  }

  @Override
  public java.lang.String toString() {
    java.lang.StringBuilder sb = new java.lang.StringBuilder("MoviePersonDataDto(");
    boolean first = true;

    if (isSetMoviePersonInfo()) {
      sb.append("moviePersonInfo:");
      if (this.moviePersonInfo == null) {
        sb.append("null");
      } else {
        sb.append(this.moviePersonInfo);
      }
      first = false;
    }
    if (isSetStatData()) {
      if (!first) sb.append(", ");
      sb.append("statData:");
      if (this.statData == null) {
        sb.append("null");
      } else {
        sb.append(this.statData);
      }
      first = false;
    }
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // check for sub-struct validity
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, java.lang.ClassNotFoundException {
    try {
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class MoviePersonDataDtoStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public MoviePersonDataDtoStandardScheme getScheme() {
      return new MoviePersonDataDtoStandardScheme();
    }
  }

  private static class MoviePersonDataDtoStandardScheme extends org.apache.thrift.scheme.StandardScheme<MoviePersonDataDto> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, MoviePersonDataDto struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // MOVIE_PERSON_INFO
            if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
              struct.moviePersonInfo = new MoviePersonInfoVo();
              struct.moviePersonInfo.read(iprot);
              struct.setMoviePersonInfoIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // STAT_DATA
            if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
              struct.statData = new MoviePersonStatDataVo();
              struct.statData.read(iprot);
              struct.setStatDataIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, MoviePersonDataDto struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.moviePersonInfo != null) {
        if (struct.isSetMoviePersonInfo()) {
          oprot.writeFieldBegin(MOVIE_PERSON_INFO_FIELD_DESC);
          struct.moviePersonInfo.write(oprot);
          oprot.writeFieldEnd();
        }
      }
      if (struct.statData != null) {
        if (struct.isSetStatData()) {
          oprot.writeFieldBegin(STAT_DATA_FIELD_DESC);
          struct.statData.write(oprot);
          oprot.writeFieldEnd();
        }
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class MoviePersonDataDtoTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public MoviePersonDataDtoTupleScheme getScheme() {
      return new MoviePersonDataDtoTupleScheme();
    }
  }

  private static class MoviePersonDataDtoTupleScheme extends org.apache.thrift.scheme.TupleScheme<MoviePersonDataDto> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, MoviePersonDataDto struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet optionals = new java.util.BitSet();
      if (struct.isSetMoviePersonInfo()) {
        optionals.set(0);
      }
      if (struct.isSetStatData()) {
        optionals.set(1);
      }
      oprot.writeBitSet(optionals, 2);
      if (struct.isSetMoviePersonInfo()) {
        struct.moviePersonInfo.write(oprot);
      }
      if (struct.isSetStatData()) {
        struct.statData.write(oprot);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, MoviePersonDataDto struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet incoming = iprot.readBitSet(2);
      if (incoming.get(0)) {
        struct.moviePersonInfo = new MoviePersonInfoVo();
        struct.moviePersonInfo.read(iprot);
        struct.setMoviePersonInfoIsSet(true);
      }
      if (incoming.get(1)) {
        struct.statData = new MoviePersonStatDataVo();
        struct.statData.read(iprot);
        struct.setStatDataIsSet(true);
      }
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}

