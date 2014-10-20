/****************************************************************************************
 * Copyright (c) 2013 Garrett <garrettwhsmith@gmail.com>                                *
 *                                                                                      *
 * This program is free software; you can redistribute it and/or modify it under        *
 * the terms of the GNU General Public License as published by the Free Software        *
 * Foundation; either version 3 of the License, or (at your option) any later           *
 * version.                                                                             *
 *                                                                                      *
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY      *
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A      *
 * PARTICULAR PURPOSE. See the GNU General Public License for more details.             *
 *                                                                                      *
 * You should have received a copy of the GNU General Public License along with         *
 * this program.  If not, see <http://www.gnu.org/licenses/>.                           *
 ****************************************************************************************/

package com.ichi2.anki2;

import android.content.Context;
import android.media.MediaRecorder;
import android.net.Uri;
import android.util.Log;

import java.io.File;
import java.io.IOException;

/**
 * Recorder allows the user to record an answer and replay it after flipping the card.
 */
public class Recorder {
    //private static Context mContext;
    private static MediaRecorder mRecorder;
    private static File mCacheFile;
    private static boolean mRecorded = false;
    private static RecordingStartedListener mStartedListener;
    private static RecordingFinishedListener mFinishedListener;
    private static RecorderResetListener mResetListener;
    
    public static void initialize(Context context) {
        //mContext = context;
        File cacheDir = context.getCacheDir();
        try {
            mCacheFile = File.createTempFile("rec", ".3gp", cacheDir);
        } catch (IOException e) {
            Log.e(AnkiDroidApp.TAG, "initialize - Error = " + e.getMessage());
        }
    }
    
    public static void releaseTempFile() {
        mCacheFile.deleteOnExit();
        mCacheFile = null;
    }
    
    // TODO add a timeout
    public static void startRecording() {
        Log.i(AnkiDroidApp.TAG, "Recording " + mCacheFile.getPath());
        
        mRecorder = new MediaRecorder();
        mRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        mRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        mRecorder.setOutputFile(mCacheFile.getPath());
        mRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);

        try {
            mRecorder.prepare();
            mRecorder.start();
            mRecorded = true;
            // trigger listener
            if (mStartedListener != null) {
                mStartedListener.onRecordingStarted();
            }
        } catch (IOException e) {
            Log.e(AnkiDroidApp.TAG, "startRecording - Error recording sound " + mCacheFile.getPath() + "Error = " + e.getMessage());
            stopRecording();
        }                
    }
    
    public static void stopRecording() {
        if (mRecorder != null) {
            Log.i(AnkiDroidApp.TAG, "Recording stopped " + mCacheFile.getPath());
            mRecorder.stop();
            mRecorder.reset();
            mRecorder.release();
            mRecorder = null;
            // trigger listener
            if (mFinishedListener != null) {
                mFinishedListener.onRecordingFinished();
            }
        }
    }
    
    public static String getPath() {
        return Uri.fromFile(mCacheFile).toString();
    }
    
    public static void reset() {
        stopRecording();
        mRecorded = false;
        // trigger listener
        if (mResetListener != null) {
            mResetListener.onRecorderReset();
        }
    }
    
    public static boolean recorded() {
        return mRecorded;
    }
    
    public static boolean recording() {
        return mRecorder != null;
    }
    
    public static void setRecordingStartedListener(RecordingStartedListener listener) {
        mStartedListener = listener;
    }
    
    public static void setRecordingFinishedListener(RecordingFinishedListener listener) {
        mFinishedListener = listener;
    }
    
    public static void setRecorderResetListener(RecorderResetListener listener) {
        mResetListener = listener;
    }
    
    /**
     * Listens for the event of starting the Recorder.
     */
    public interface RecordingStartedListener{
        public void onRecordingStarted();
    }
    
    /**
     * Listens for the event of stopping the Recorder.
     */
    public interface RecordingFinishedListener {
        public void onRecordingFinished();
    }
    
    /**
     * Listens for the event of reseting the Recorder.
     */
    public interface RecorderResetListener {
        public void onRecorderReset();
    }

}
