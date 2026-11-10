package hu.kaminari.dojo;
import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebSettings;
import android.webkit.WebViewClient;
import android.webkit.WebChromeClient;
import android.webkit.ValueCallback;
import android.content.Intent;
import android.net.Uri;
public class MainActivity extends Activity {
 private WebView web; private ValueCallback<Uri[]> chooser; private static final int FILE_REQ=123;
 @Override public void onCreate(Bundle b){super.onCreate(b); web=new WebView(this);web.getSettings().setJavaScriptEnabled(true);web.getSettings().setDomStorageEnabled(true);web.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);web.setWebViewClient(new WebViewClient(){@Override public boolean shouldOverrideUrlLoading(WebView view,String url){return handleExternalUrl(url);}@Override public boolean shouldOverrideUrlLoading(WebView view,android.webkit.WebResourceRequest request){return handleExternalUrl(request.getUrl().toString());}});web.setWebChromeClient(new WebChromeClient(){@Override public boolean onShowFileChooser(WebView v,ValueCallback<Uri[]> callback,FileChooserParams params){chooser=callback;try{startActivityForResult(params.createIntent(),FILE_REQ);return true;}catch(Exception e){chooser=null;return false;}}});setContentView(web);web.loadUrl("https://kaminaridojohgyork-arch.github.io/kaminari-dojo/dojo.html?v=20261110gyerek1");}
 private boolean handleExternalUrl(String url){if(url==null)return false;if(url.startsWith("tel:")){try{startActivity(new Intent(Intent.ACTION_DIAL,Uri.parse(url)));}catch(Exception e){android.widget.Toast.makeText(this,"Nem sikerült megnyitni a tárcsázót.",android.widget.Toast.LENGTH_SHORT).show();}return true;}if(url.startsWith("mailto:")){try{startActivity(new Intent(Intent.ACTION_SENDTO,Uri.parse(url)));}catch(Exception e){android.widget.Toast.makeText(this,"Nem található levelező alkalmazás.",android.widget.Toast.LENGTH_SHORT).show();}return true;}return false;}\n @Override protected void onActivityResult(int request,int result,Intent data){super.onActivityResult(request,result,data);if(request==FILE_REQ&&chooser!=null){chooser.onReceiveValue(WebChromeClient.FileChooserParams.parseResult(result,data));chooser=null;}}
 @Override public void onBackPressed(){if(web.canGoBack())web.goBack();else super.onBackPressed();}
}
