package io.github.bissal.messy.test.convert;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class ConvertBetweenIntegernnByteArrayTest2 {
	
	public ConvertBetweenIntegernnByteArrayTest2() {
		InputStream a = null;
		ByteArrayOutputStream bAOuput= new ByteArrayOutputStream(4);
		DataOutputStream dOutput = new DataOutputStream(bAOuput);
		
		
		int headerSize = 0;
		int bodySize = 0;
		
		int testSize = -91185805;
		
		try {
			dOutput.writeInt(testSize);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		byte [] intToBytesValue = bAOuput.toByteArray();
		
		for (byte b : intToBytesValue) {
			System.out.println(b+" ");
		}
		
	
		
		//byte sample[] = new byte[4];
		ByteArrayInputStream bAInput = new ByteArrayInputStream(intToBytesValue);
		DataInputStream dInput = new DataInputStream(bAInput);
		try {
			int sampleInt = dInput.readInt();
			System.out.println("ByteToInt ="+sampleInt);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		byte[] version = new byte[2];
		byte[] size = new byte[4];
		byte[] action = new byte[4];


		headerSize = version.length + size.length;
		bodySize = action.length;

		version[0] = 0x01;
		version[1] = 0x02;
		size = intToBytes(testSize);
		
		int result = bytesToInt(size);

		System.out.println("version[0] : " + version[0]);
		System.out.println("##############################################");
		System.out.println("result int " + testSize  + " --> bytes --> int : " + result);

		return;
	}

	public byte[] intToBytes( int i ) {

		byte[] b = new byte[4];
		b[ 0 ] = ( byte ) ( ( i >>> 24 ) & 0xFF );
		b[ 1 ] = ( byte ) ( ( i >>> 16 ) & 0xFF );
		b[ 2 ] = ( byte ) ( ( i >>> 8 ) & 0xFF );
		b[ 3 ] = ( byte ) ( ( i >>> 0 ) & 0xFF );

		return b;
	}

	private int bytesToInt( byte[] bytes )
    {
        int newValue = 0;
        switch ( bytes.length )
        {
            case 1 :
                newValue |= ( bytes[ 0 ] ) & 0xFF;
                break;
            case 2 :
                newValue |= ( ( bytes[ 0 ] ) << 8 ) & 0xFF00;
                newValue |= ( bytes[ 1 ] ) & 0xFF;
                break;
            case 3 :
                newValue |= ( ( bytes[ 0 ] ) << 16 ) & 0xFF0000;
                newValue |= ( ( bytes[ 1 ] ) << 8 ) & 0xFF00;
                newValue |= ( bytes[ 2 ] ) & 0xFF;
                break;
            case 4 :
                newValue |= ( ( bytes[ 0 ] ) << 24 ) & 0xFF000000;
                newValue |= ( ( bytes[ 1 ] ) << 16 ) & 0xFF0000;
                newValue |= ( ( bytes[ 2 ] ) << 8 ) & 0xFF00;
                newValue |= ( bytes[ 3 ] ) & 0xFF;
            default :
                break;
        }
        return newValue;
    }	
}
