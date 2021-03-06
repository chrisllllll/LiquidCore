/*
 * Copyright (c) 2014 - 2018 Eric Lange
 *
 * Distributed under the MIT License.  See LICENSE.md at
 * https://github.com/LiquidPlayer/LiquidCore for terms and conditions.
 */
package org.liquidplayer.javascript;

/**
 * A wrapper class for a JavaScript DataView
 * See: https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/DataView
 * @since 0.1.0
 */
@SuppressWarnings("WeakerAccess,SameParameterValue")
public class JSDataView extends JSObjectWrapper {

    /**
     * Creates a new DataView JavaScript object from ArrayBuffer 'buffer' and wraps it for Java
     * @param buffer  the JSArrayBuffer to create a DataView from
     * @since 0.1.0
     */
    public JSDataView(JSArrayBuffer buffer) {
        super(new JSFunction(buffer.getJSObject().getContext(),
                "_DataView",new String[] {"buffer"},

                "return new DataView(buffer);",
                null, 0).call(null,buffer).toObject());
    }
    /**
     * Creates a new DataView JavaScript object from ArrayBuffer 'buffer' starting from
     * 'byteOffset' and wraps it for Java
     * @param buffer  the JSArrayBuffer to create a DataView from
     * @param byteOffset the byte offset in 'buffer' to create the DataView from
     * @since 0.1.0
     */
    public JSDataView(JSArrayBuffer buffer, int byteOffset) {
        super(new JSFunction(buffer.getJSObject().getContext(),
                "_DataView1",new String[] {"buffer","byteOffset"},

                "return new DataView(buffer,byteOffset);",
                null, 0).call(null,buffer,byteOffset).toObject());
    }
    /**
     * Creates a new DataView JavaScript object from ArrayBuffer 'buffer' starting from
     * 'byteOffset' and wraps it for Java
     * @param buffer  the JSArrayBuffer to create a DataView from
     * @param byteOffset the byte offset in 'buffer' to create the DataView from
     * @param byteLength the length, in bytes, from 'byteOffset' to use for the DataView
     * @since 0.1.0
     */
    public JSDataView(JSArrayBuffer buffer, int byteOffset, int byteLength) {
        super(new JSFunction(buffer.getJSObject().getContext(),
                "_DataView2",new String[] {"buffer","byteOffset","byteLength"},

                "return new DataView(buffer,byteOffset,byteLength);",
                null, 0).call(null,buffer,byteOffset,byteLength).toObject());
    }

    /**
     * Treats an existing JSObject as a DataView.  It is up to the user to ensure the
     * underlying JSObject is actually an DataView.
     * @param view  The DataView JSObject to wrap
     * @since 0.1.0
     */
    public JSDataView(JSObject view) {
        super(view);
    }

    /**
     * JavasScript DataView.prototype.buffer, see:
     * https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/DataView/buffer
     * @return the JSArrayBuffer on which the DataView is built
     * @since 0.1.0
     */
    public JSArrayBuffer buffer() {
        return new JSArrayBuffer(property("buffer").toObject());
    }

    /**
     * JavasScript DataView.prototype.byteLength, see:
     * https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/DataView/byteLength
     * @return the length in bytes of the DataView
     * @since 0.1.0
     */
    public int byteLength() {
        return property("byteLength").toNumber().intValue();
    }

    /**
     * JavasScript DataView.prototype.byteOffset, see:
     * https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/DataView/byteOffset
     * @since 0.1.0
     * @return the byte offset in the JSArrayBuffer where the DataView starts
     */
    public int byteOffset() {
        return property("byteOffset").toNumber().intValue();
    }

    /**
     * JavasScript DataView.prototype.getFloat32(), see:
     * https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/DataView/getFloat32
     * @since 0.1.0
     * @param byteOffset  the byte offset to read from
     * @param littleEndian  whether the value is stored with little endianness
     * @return the value at byteOffset
     */
    public Float getFloat32(int byteOffset, boolean littleEndian) {
        return property("getFloat32").toFunction().call(this,byteOffset,littleEndian)
                .toNumber().floatValue();
    }
    /**
     * JavasScript DataView.prototype.getFloat32(), see:
     * https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/DataView/getFloat32
     * @since 0.1.0
     * @param byteOffset  the byte offset to read from
     * @return the value at byteOffset
     */
    public Float getFloat32(int byteOffset) {
        return property("getFloat32").toFunction().call(this,byteOffset)
                .toNumber().floatValue();
    }

    /**
     * JavasScript DataView.prototype.setFloat32(), see:
     * https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/DataView/setFloat32
     * @since 0.1.0
     * @param byteOffset  the byte offset to write to
     * @param value the value to store at 'byteOffset'
     * @param littleEndian  whether the value is to be stored with little endianness
     */
    public void setFloat32(int byteOffset, Float value, boolean littleEndian) {
        property("setFloat32").toFunction().call(this,byteOffset,value,littleEndian);
    }
    /**
     * JavasScript DataView.prototype.setFloat32(), see:
     * https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/DataView/setFloat32
     * @since 0.1.0
     * @param byteOffset  the byte offset to write to
     * @param value the value to store at 'byteOffset'
     */
    public void setFloat32(int byteOffset, Float value) {
        property("setFloat32").toFunction().call(this,byteOffset,value);
    }

    /**
     * JavasScript DataView.prototype.getFloat64(), see:
     * https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/DataView/getFloat64
     * @since 0.1.0
     * @param byteOffset  the byte offset to read from
     * @param littleEndian  whether the value is stored with little endianness
     * @return the value at byteOffset
     */
    public Double getFloat64(int byteOffset, boolean littleEndian) {
        return property("getFloat64").toFunction().call(this,byteOffset,littleEndian)
                .toNumber();
    }
    /**
     * JavasScript DataView.prototype.getFloat64(), see:
     * https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/DataView/getFloat64
     * @since 0.1.0
     * @param byteOffset  the byte offset to read from
     * @return the value at byteOffset
     */
    public Double getFloat64(int byteOffset) {
        return property("getFloat64").toFunction().call(this,byteOffset)
                .toNumber();
    }

    /**
     * JavasScript DataView.prototype.setFloat64(), see:
     * https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/DataView/setFloat64
     * @since 0.1.0
     * @param byteOffset  the byte offset to write to
     * @param value the value to store at 'byteOffset'
     * @param littleEndian  whether the value is to be stored with little endianness
     */
    public void setFloat64(int byteOffset, Double value, boolean littleEndian) {
        property("setFloat64").toFunction().call(this,byteOffset,value,littleEndian);
    }
    /**
     * JavasScript DataView.prototype.setFloat64(), see:
     * https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/DataView/setFloat64
     * @since 0.1.0
     * @param byteOffset  the byte offset to write to
     * @param value the value to store at 'byteOffset'
     */
    public void setFloat64(int byteOffset, Double value) {
        property("setFloat64").toFunction().call(this,byteOffset,value);
    }

    /**
     * JavasScript DataView.prototype.getInt32(), see:
     * https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/DataView/getInt32
     * @since 0.1.0
     * @param byteOffset  the byte offset to read from
     * @param littleEndian  whether the value is stored with little endianness
     * @return the value at byteOffset
     */
    public Integer getInt32(int byteOffset, boolean littleEndian) {
        return property("getInt32").toFunction().call(this,byteOffset,littleEndian)
                .toNumber().intValue();
    }
    /**
     * JavasScript DataView.prototype.getInt32(), see:
     * https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/DataView/getInt32
     * @since 0.1.0
     * @param byteOffset  the byte offset to read from
     * @return the value at byteOffset
     */
    public Integer getInt32(int byteOffset) {
        return property("getInt32").toFunction().call(this,byteOffset)
                .toNumber().intValue();
    }

    /**
     * JavasScript DataView.prototype.setInt32(), see:
     * https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/DataView/setInt32
     * @since 0.1.0
     * @param byteOffset  the byte offset to write to
     * @param value the value to store at 'byteOffset'
     * @param littleEndian  whether the value is to be stored with little endianness
     */
    public void setInt32(int byteOffset, Integer value, boolean littleEndian) {
        property("setInt32").toFunction().call(this,byteOffset,value,littleEndian);
    }
    /**
     * JavasScript DataView.prototype.setInt32(), see:
     * https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/DataView/setInt32
     * @since 0.1.0
     * @param byteOffset  the byte offset to write to
     * @param value the value to store at 'byteOffset'
     */
    public void setInt32(int byteOffset, Integer value) {
        property("setInt32").toFunction().call(this,byteOffset,value);
    }

    /**
     * JavasScript DataView.prototype.getUint32(), see:
     * https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/DataView/getUint32
     * @since 0.1.0
     * @param byteOffset  the byte offset to read from
     * @param littleEndian  whether the value is stored with little endianness
     * @return the value at byteOffset
     */
    public Long getUint32(int byteOffset, boolean littleEndian) {
        return property("getUint32").toFunction().call(this,byteOffset,littleEndian)
                .toNumber().longValue();
    }
    /**
     * JavasScript DataView.prototype.getUint32(), see:
     * https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/DataView/getUint32
     * @param byteOffset  the byte offset to read from
     * @return the value at byteOffset
     * @since 0.1.0
     */
    public Long getUint32(int byteOffset) {
        return property("getUint32").toFunction().call(this,byteOffset)
                .toNumber().longValue();
    }

    /**
     * JavasScript DataView.prototype.setUint32(), see:
     * https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/DataView/setUint32
     * @param byteOffset  the byte offset to write to
     * @param value the value to store at 'byteOffset'
     * @param littleEndian  whether the value is to be stored with little endianness
     * @since 0.1.0
     */
    public void setUint32(int byteOffset, Long value, boolean littleEndian) {
        property("setUint32").toFunction().call(this,byteOffset,value,littleEndian);
    }
    /**
     * JavasScript DataView.prototype.setUint32(), see:
     * https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/DataView/setUint32
     * @since 0.1.0
     * @param byteOffset  the byte offset to write to
     * @param value the value to store at 'byteOffset'
     */
    public void setUint32(int byteOffset, Long value) {
        property("setUint32").toFunction().call(this,byteOffset,value);
    }

    /**
     * JavasScript DataView.prototype.getInt16(), see:
     * https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/DataView/getInt16
     * @since 0.1.0
     * @param byteOffset  the byte offset to read from
     * @param littleEndian  whether the value is stored with little endianness
     * @return the value at byteOffset
     */
    public Short getInt16(int byteOffset, boolean littleEndian) {
        return property("getInt16").toFunction().call(this,byteOffset,littleEndian)
                .toNumber().shortValue();
    }
    /**
     * JavasScript DataView.prototype.getInt16(), see:
     * https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/DataView/getInt16
     * @since 0.1.0
     * @param byteOffset  the byte offset to read from
     * @return the value at byteOffset
     */
    public Short getInt16(int byteOffset) {
        return property("getInt16").toFunction().call(this,byteOffset)
                .toNumber().shortValue();
    }

    /**
     * JavasScript DataView.prototype.setInt16(), see:
     * https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/DataView/setInt16
     * @since 0.1.0
     * @param byteOffset  the byte offset to write to
     * @param value the value to store at 'byteOffset'
     * @param littleEndian  whether the value is to be stored with little endianness
     */
    public void setInt16(int byteOffset, Short value, boolean littleEndian) {
        property("setInt16").toFunction().call(this,byteOffset,value,littleEndian);
    }
    /**
     * JavasScript DataView.prototype.setInt16(), see:
     * https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/DataView/setInt16
     * @since 0.1.0
     * @param byteOffset  the byte offset to write to
     * @param value the value to store at 'byteOffset'
     */
    public void setInt16(int byteOffset, Short value) {
        property("setInt16").toFunction().call(this,byteOffset,value);
    }

    /**
     * JavasScript DataView.prototype.getUint16(), see:
     * https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/DataView/getUint16
     * @since 0.1.0
     * @param byteOffset  the byte offset to read from
     * @param littleEndian  whether the value is stored with little endianness
     * @return the value at byteOffset
     */
    public Short getUint16(int byteOffset, boolean littleEndian) {
        return property("getUint16").toFunction().call(this,byteOffset,littleEndian)
                .toNumber().shortValue();
    }
    /**
     * JavasScript DataView.prototype.getUint16(), see:
     * https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/DataView/getUint16
     * @since 0.1.0
     * @param byteOffset  the byte offset to read from
     * @return the value at byteOffset
     */
    public Short getUint16(int byteOffset) {
        return property("getUint16").toFunction().call(this,byteOffset)
                .toNumber().shortValue();
    }

    /**
     * JavasScript DataView.prototype.setUint16(), see:
     * https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/DataView/setUint16
     * @since 0.1.0
     * @param byteOffset  the byte offset to write to
     * @param value the value to store at 'byteOffset'
     * @param littleEndian  whether the value is to be stored with little endianness
     */
    public void setUint16(int byteOffset, Short value, boolean littleEndian) {
        property("setUint16").toFunction().call(this,byteOffset,value,littleEndian);
    }
    /**
     * JavasScript DataView.prototype.setUint16(), see:
     * https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/DataView/setUint16
     * @since 0.1.0
     * @param byteOffset  the byte offset to write to
     * @param value the value to store at 'byteOffset'
     */
    public void setUint16(int byteOffset, Short value) {
        property("setUint16").toFunction().call(this,byteOffset,value);
    }

    /**
     * JavasScript DataView.prototype.getInt8(), see:
     * https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/DataView/getInt8
     * @since 0.1.0
     * @param byteOffset  the byte offset to read from
     * @return the value at byteOffset
     */
    public Byte getInt8(int byteOffset) {
        return property("getInt8").toFunction().call(this,byteOffset)
                .toNumber().byteValue();
    }

    /**
     * JavasScript DataView.prototype.setInt8(), see:
     * https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/DataView/setInt8
     * @since 0.1.0
     * @param byteOffset  the byte offset to write to
     * @param value the value to store at 'byteOffset'
     */
    public void setInt8(int byteOffset, Byte value) {
        property("setInt8").toFunction().call(this,byteOffset,value);
    }

    /**
     * JavasScript DataView.prototype.getUint8(), see:
     * https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/DataView/getUint8
     * @since 0.1.0
     * @param byteOffset  the byte offset to read from
     * @return the value at byteOffset
     */
    public Byte getUint8(int byteOffset) {
        return property("getUint8").toFunction().call(this,byteOffset)
                .toNumber().byteValue();
    }

    /**
     * JavasScript DataView.prototype.setUint8(), see:
     * https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/DataView/setUint8
     * @since 0.1.0
     * @param byteOffset  the byte offset to write to
     * @param value the value to store at 'byteOffset'
     */
    public void setUint8(int byteOffset, Byte value) {
        property("setUint8").toFunction().call(this,byteOffset,value);
    }

}
