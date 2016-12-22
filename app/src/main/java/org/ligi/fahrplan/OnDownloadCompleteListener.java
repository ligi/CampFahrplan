package org.ligi.fahrplan;

interface OnDownloadCompleteListener {

    public void onGotResponse(CustomHttpClient.HTTP_STATUS status, String response, String eTagStr, String host);
}
