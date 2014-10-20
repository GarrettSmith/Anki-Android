/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: /home/garrett/dev/Anki-Android/src/com/ichi2/anki2/services/IDownloadManagerService.aidl
 */
package com.ichi2.anki2.services;
/**
 * Example of defining an interface for calling on to a remote service
 * (running in another process).
 */
public interface IDownloadManagerService extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements com.ichi2.anki2.services.IDownloadManagerService
{
private static final java.lang.String DESCRIPTOR = "com.ichi2.anki2.services.IDownloadManagerService";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an com.ichi2.anki2.services.IDownloadManagerService interface,
 * generating a proxy if needed.
 */
public static com.ichi2.anki2.services.IDownloadManagerService asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof com.ichi2.anki2.services.IDownloadManagerService))) {
return ((com.ichi2.anki2.services.IDownloadManagerService)iin);
}
return new com.ichi2.anki2.services.IDownloadManagerService.Stub.Proxy(obj);
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
case TRANSACTION_registerPersonalDeckCallback:
{
data.enforceInterface(DESCRIPTOR);
com.ichi2.anki2.services.IPersonalDeckServiceCallback _arg0;
_arg0 = com.ichi2.anki2.services.IPersonalDeckServiceCallback.Stub.asInterface(data.readStrongBinder());
this.registerPersonalDeckCallback(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_unregisterPersonalDeckCallback:
{
data.enforceInterface(DESCRIPTOR);
com.ichi2.anki2.services.IPersonalDeckServiceCallback _arg0;
_arg0 = com.ichi2.anki2.services.IPersonalDeckServiceCallback.Stub.asInterface(data.readStrongBinder());
this.unregisterPersonalDeckCallback(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_registerSharedDeckCallback:
{
data.enforceInterface(DESCRIPTOR);
com.ichi2.anki2.services.ISharedDeckServiceCallback _arg0;
_arg0 = com.ichi2.anki2.services.ISharedDeckServiceCallback.Stub.asInterface(data.readStrongBinder());
this.registerSharedDeckCallback(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_unregisterSharedDeckCallback:
{
data.enforceInterface(DESCRIPTOR);
com.ichi2.anki2.services.ISharedDeckServiceCallback _arg0;
_arg0 = com.ichi2.anki2.services.ISharedDeckServiceCallback.Stub.asInterface(data.readStrongBinder());
this.unregisterSharedDeckCallback(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_getPersonalDeckDownloads:
{
data.enforceInterface(DESCRIPTOR);
java.util.List<com.ichi2.anki2.Download> _result = this.getPersonalDeckDownloads();
reply.writeNoException();
reply.writeTypedList(_result);
return true;
}
case TRANSACTION_getSharedDeckDownloads:
{
data.enforceInterface(DESCRIPTOR);
java.util.List<com.ichi2.anki2.SharedDeckDownload> _result = this.getSharedDeckDownloads();
reply.writeNoException();
reply.writeTypedList(_result);
return true;
}
case TRANSACTION_downloadFile:
{
data.enforceInterface(DESCRIPTOR);
com.ichi2.anki2.Download _arg0;
if ((0!=data.readInt())) {
_arg0 = com.ichi2.anki2.Download.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
this.downloadFile(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_resumeDownloadUpdating:
{
data.enforceInterface(DESCRIPTOR);
com.ichi2.anki2.Download _arg0;
if ((0!=data.readInt())) {
_arg0 = com.ichi2.anki2.Download.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
this.resumeDownloadUpdating(_arg0);
reply.writeNoException();
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
private static class Proxy implements com.ichi2.anki2.services.IDownloadManagerService
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
     * Often you want to allow a service to call back to its clients.
     * This shows how to do so, by registering a callback interface with
     * the service.
     */
@Override public void registerPersonalDeckCallback(com.ichi2.anki2.services.IPersonalDeckServiceCallback cb) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((cb!=null))?(cb.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_registerPersonalDeckCallback, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
     * Remove a previously registered callback interface.
     */
@Override public void unregisterPersonalDeckCallback(com.ichi2.anki2.services.IPersonalDeckServiceCallback cb) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((cb!=null))?(cb.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_unregisterPersonalDeckCallback, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
     * Often you want to allow a service to call back to its clients.
     * This shows how to do so, by registering a callback interface with
     * the service.
     */
@Override public void registerSharedDeckCallback(com.ichi2.anki2.services.ISharedDeckServiceCallback cb) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((cb!=null))?(cb.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_registerSharedDeckCallback, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
     * Remove a previously registered callback interface.
     */
@Override public void unregisterSharedDeckCallback(com.ichi2.anki2.services.ISharedDeckServiceCallback cb) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((cb!=null))?(cb.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_unregisterSharedDeckCallback, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public java.util.List<com.ichi2.anki2.Download> getPersonalDeckDownloads() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.util.List<com.ichi2.anki2.Download> _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getPersonalDeckDownloads, _data, _reply, 0);
_reply.readException();
_result = _reply.createTypedArrayList(com.ichi2.anki2.Download.CREATOR);
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public java.util.List<com.ichi2.anki2.SharedDeckDownload> getSharedDeckDownloads() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.util.List<com.ichi2.anki2.SharedDeckDownload> _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getSharedDeckDownloads, _data, _reply, 0);
_reply.readException();
_result = _reply.createTypedArrayList(com.ichi2.anki2.SharedDeckDownload.CREATOR);
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public void downloadFile(com.ichi2.anki2.Download download) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((download!=null)) {
_data.writeInt(1);
download.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_downloadFile, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void resumeDownloadUpdating(com.ichi2.anki2.Download download) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((download!=null)) {
_data.writeInt(1);
download.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_resumeDownloadUpdating, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
}
static final int TRANSACTION_registerPersonalDeckCallback = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
static final int TRANSACTION_unregisterPersonalDeckCallback = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
static final int TRANSACTION_registerSharedDeckCallback = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
static final int TRANSACTION_unregisterSharedDeckCallback = (android.os.IBinder.FIRST_CALL_TRANSACTION + 3);
static final int TRANSACTION_getPersonalDeckDownloads = (android.os.IBinder.FIRST_CALL_TRANSACTION + 4);
static final int TRANSACTION_getSharedDeckDownloads = (android.os.IBinder.FIRST_CALL_TRANSACTION + 5);
static final int TRANSACTION_downloadFile = (android.os.IBinder.FIRST_CALL_TRANSACTION + 6);
static final int TRANSACTION_resumeDownloadUpdating = (android.os.IBinder.FIRST_CALL_TRANSACTION + 7);
}
/**
     * Often you want to allow a service to call back to its clients.
     * This shows how to do so, by registering a callback interface with
     * the service.
     */
public void registerPersonalDeckCallback(com.ichi2.anki2.services.IPersonalDeckServiceCallback cb) throws android.os.RemoteException;
/**
     * Remove a previously registered callback interface.
     */
public void unregisterPersonalDeckCallback(com.ichi2.anki2.services.IPersonalDeckServiceCallback cb) throws android.os.RemoteException;
/**
     * Often you want to allow a service to call back to its clients.
     * This shows how to do so, by registering a callback interface with
     * the service.
     */
public void registerSharedDeckCallback(com.ichi2.anki2.services.ISharedDeckServiceCallback cb) throws android.os.RemoteException;
/**
     * Remove a previously registered callback interface.
     */
public void unregisterSharedDeckCallback(com.ichi2.anki2.services.ISharedDeckServiceCallback cb) throws android.os.RemoteException;
public java.util.List<com.ichi2.anki2.Download> getPersonalDeckDownloads() throws android.os.RemoteException;
public java.util.List<com.ichi2.anki2.SharedDeckDownload> getSharedDeckDownloads() throws android.os.RemoteException;
public void downloadFile(com.ichi2.anki2.Download download) throws android.os.RemoteException;
public void resumeDownloadUpdating(com.ichi2.anki2.Download download) throws android.os.RemoteException;
}
