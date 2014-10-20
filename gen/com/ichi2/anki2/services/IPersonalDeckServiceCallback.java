/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: /home/garrett/dev/Anki-Android/src/com/ichi2/anki2/services/IPersonalDeckServiceCallback.aidl
 */
package com.ichi2.anki2.services;
/**
 * Example of a callback interface used by IDownloadManagerService to send
 * synchronous notifications back to its clients.  Note that this is a
 * one-way interface so the server does not block waiting for the client.
 */
public interface IPersonalDeckServiceCallback extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements com.ichi2.anki2.services.IPersonalDeckServiceCallback
{
private static final java.lang.String DESCRIPTOR = "com.ichi2.anki2.services.IPersonalDeckServiceCallback";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an com.ichi2.anki2.services.IPersonalDeckServiceCallback interface,
 * generating a proxy if needed.
 */
public static com.ichi2.anki2.services.IPersonalDeckServiceCallback asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof com.ichi2.anki2.services.IPersonalDeckServiceCallback))) {
return ((com.ichi2.anki2.services.IPersonalDeckServiceCallback)iin);
}
return new com.ichi2.anki2.services.IPersonalDeckServiceCallback.Stub.Proxy(obj);
}
@Override public android.os.IBinder asBinder()
{
return this;
}
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_publishProgress:
{
data.enforceInterface(DESCRIPTOR);
java.util.List<com.ichi2.anki2.Download> _arg0;
_arg0 = data.createTypedArrayList(com.ichi2.anki2.Download.CREATOR);
this.publishProgress(_arg0);
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
private static class Proxy implements com.ichi2.anki2.services.IPersonalDeckServiceCallback
{
private android.os.IBinder mRemote;
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@Override public android.os.IBinder asBinder()
{
return mRemote;
}
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
/**
     * Called when the service has a new value for you.
     */
@Override public void publishProgress(java.util.List<com.ichi2.anki2.Download> downloads) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeTypedList(downloads);
mRemote.transact(Stub.TRANSACTION_publishProgress, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
}
static final int TRANSACTION_publishProgress = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
}
/**
     * Called when the service has a new value for you.
     */
public void publishProgress(java.util.List<com.ichi2.anki2.Download> downloads) throws android.os.RemoteException;
}
