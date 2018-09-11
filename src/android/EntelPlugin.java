package pt.wingman.entel.plugin;

import android.content.Context;
import android.widget.Toast;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.PluginResult;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import pt.wingman.entel.plugin.FingerprintManager;
import pt.wingman.entel.plugin.FingerprintManagerCallback;

public class EntelPlugin extends CordovaPlugin {
    @Override
    public boolean execute(String action, JSONArray args, final CallbackContext callbackContext) {
        if (action.equals("start")) {
            int compressionAlgorithm;
            int compressionRate;
            boolean latentDetection;
            
            try {
                JSONObject jsonObject = args.getJSONObject(0);
                compressionAlgorithm = jsonObject.getInt("compressionAlgorithm");
                compressionRate = jsonObject.getInt("compressionRate");
                latentDetection = jsonObject.getBoolean("latentDetection");
            } catch (JSONException e) {
                PluginResult pluginResult = new  PluginResult(PluginResult.Status.JSON_EXCEPTION);
                callbackContext.error(e.getMessage());
                return false;
            }
         
            Context context = cordova.getActivity().getApplicationContext();
            FingerprintManager.getInstance().initialize(context, getFingerprintManagerCallback(context, callbackContext), compressionAlgorithm, compressionRate, latentDetection);

            PluginResult pluginResult = new  PluginResult(PluginResult.Status.NO_RESULT);
            pluginResult.setKeepCallback(true);
            callbackContext.sendPluginResult(pluginResult);
            return true;
        }

        if (action.equals("stop")) {
            FingerprintManager.getInstance().stop();
            PluginResult pluginResult = new PluginResult(PluginResult.Status.OK);
            callbackContext.sendPluginResult(pluginResult);
            return true;
        }

        PluginResult pluginResult = new PluginResult(PluginResult.Status.OK);
        callbackContext.sendPluginResult(pluginResult);
        return true;
    }
	
	private String encode(byte[] d) {
        if (d == null) {
            return null;
        }
        int idx;
        byte[] data = new byte[(d.length + 2)];
        System.arraycopy(d, 0, data, 0, d.length);
        byte[] dest = new byte[((data.length / 3) * 4)];
        int sidx = 0;
        int didx = 0;
        while (sidx < d.length) {
            dest[didx] = (byte) ((data[sidx] >>> 2) & 63);
            dest[didx + 1] = (byte) (((data[sidx + 1] >>> 4) & 15) | ((data[sidx] << 4) & 63));
            dest[didx + 2] = (byte) (((data[sidx + 2] >>> 6) & 3) | ((data[sidx + 1] << 2) & 63));
            dest[didx + 3] = (byte) (data[sidx + 2] & 63);
            sidx += 3;
            didx += 4;
        }
        for (idx = 0; idx < dest.length; idx++) {
            if (dest[idx] < (byte) 26) {
                dest[idx] = (byte) (dest[idx] + 65);
            } else if (dest[idx] < (byte) 52) {
                dest[idx] = (byte) ((dest[idx] + 97) - 26);
            } else if (dest[idx] < (byte) 62) {
                dest[idx] = (byte) ((dest[idx] + 48) - 52);
            } else if (dest[idx] < (byte) 63) {
                dest[idx] = (byte) 43;
            } else {
                dest[idx] = (byte) 47;
            }
        }
        for (idx = dest.length - 1; idx > (d.length * 4) / 3; idx--) {
            dest[idx] = (byte) 61;
        }
        return new String(dest);
    }

    private FingerprintManagerCallback getFingerprintManagerCallback(Context context, final CallbackContext callbackContext) {
        return new FingerprintManagerCallback() {
            public void onFingerStatusUpdate(int fingerStatus) {
                PluginResult pluginResult = new  PluginResult(PluginResult.Status.OK, "{\"onFingerStatusUpdate\":{\"fingerStatus\":"+fingerStatus+"}}");
                pluginResult.setKeepCallback(true);
                callbackContext.sendPluginResult(pluginResult);
            }

            public void onBitmapUpdate(int width, int height, String base64String) {
                PluginResult pluginResult = new  PluginResult(PluginResult.Status.OK, "{\"onBitmapUpdate\":{\"width\":"+width+",\"height\":"+height+",\"base64String\":\""+base64String+"\"}}");
                pluginResult.setKeepCallback(true);
                callbackContext.sendPluginResult(pluginResult);
            }

            public void onPercentageUpdate(int percentage) {
                PluginResult pluginResult = new  PluginResult(PluginResult.Status.OK, "{\"onPercentageUpdate\":{\"percentage\":"+percentage+"}}");
                pluginResult.setKeepCallback(true);
                callbackContext.sendPluginResult(pluginResult);
            }

            public void onFingerprintStatusUpdate(int fingerprintStatus) {
                PluginResult pluginResult = new  PluginResult(PluginResult.Status.OK, "{\"onFingerprintStatusUpdate\":{\"fingerprintStatus\":"+fingerprintStatus+"}}");
                pluginResult.setKeepCallback(true);
                callbackContext.sendPluginResult(pluginResult);
            }

            public void onError(int errorCode) {
                PluginResult pluginResult = new  PluginResult(PluginResult.Status.ERROR, "{\"onError\":{\"errorCode\":"+errorCode+"}}");
                pluginResult.setKeepCallback(true);
                callbackContext.sendPluginResult(pluginResult);
            }

            public void onSDKError(int sdkErrorCode, String errorMessage) {
                PluginResult pluginResult = new  PluginResult(PluginResult.Status.ERROR, "{\"onSDKError\":{\"sdkErrorCode\":"+sdkErrorCode+",\"errorMessage\":\""+errorMessage+"\"}}");
                pluginResult.setKeepCallback(true);
                callbackContext.sendPluginResult(pluginResult);
            }
        };
    }
}
