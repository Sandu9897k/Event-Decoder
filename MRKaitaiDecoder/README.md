~~~shell
java -cp MRKaitaiDecoder-1.0.0.jar com.altria.dialog.HuaweiConverterApp ../../../mr-kaitai/data/1_9817_all.dat  1_9817_all.json
~~~

> Note: byte fields may be represented as negative values, as java doesn't have unsigned byte types. 
> To overcome this, you may need to use java int[] and convert the byte value to int as follows
> `(int)(byteVal & 0xff)`
> 
> ex: 
> `this.plmnId = this._io.readBytes(3); // Need to convert each byte to int with & 0xff`