package routines;

import com.google.gdata.client.webmastertools.WebmasterToolsService;
import com.google.gdata.data.Link;
import com.google.gdata.data.OutOfLineContent;
import com.google.gdata.data.webmastertools.CrawlRate;
import com.google.gdata.data.webmastertools.DomainPreference;
import com.google.gdata.data.webmastertools.SitemapsEntry;
import com.google.gdata.data.webmastertools.SitemapsFeed;
import com.google.gdata.data.webmastertools.SitemapsRegularEntry;
import com.google.gdata.data.webmastertools.SitesEntry;
import com.google.gdata.data.webmastertools.SitesFeed;
import com.google.gdata.data.webmastertools.VerificationMethod;
import com.google.gdata.util.AuthenticationException;
import com.google.gdata.util.ServiceException;


import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class islabs_common {

	  // URL of the base feed
	  public static final String FEED_URI_BASE
	      = "https://www.google.com/webmasters/tools/feeds/";

	  // Directory of the sites feed
	  public static final String SITES_FEED_DIRECTORY = "sites/";
	  
	  // Directory of the sitemaps feed for a particular site
	  public static final String SITEMAPS_FEED_DIRECTORY = "/sitemaps/";

	  // Sample site URL. No verification required to add or remove sites
	  // Please keep the trailing slash, it is required to access the site
	  public static final String SAMPLE_SITE = "http://www.example.com/";

			  // Desired crawl rate, SLOWER, NORMAL, FASTER. See CrawlRate
	  	  // Preferred domain. NONE, PREFER_WWW, PREFER_NO_WWW. See Domain Preference
	  public static final DomainPreference SAMPLE_PREFERRED_DOMAIN
	      = DomainPreference.PREFER_WWW;

	  // Enable enhanced image search for the site
	  public static final boolean SAMPLE_ENHANCED_IMAGE_SEARCH = true;

	  // Sitemap type. Supported types include WEB, MOBILE, CODE, VIDEO, and NEWS.
	  // See http://code.google.com/apis/webmastertools/docs/developers_guide.html#Sitemaps
	  public static final String GENERAL_WEB_SITEMAP = "WEB";
  
	  public static URL getSitesFeedUrl() throws IOException {
		    try {
		      return new URL(FEED_URI_BASE + SITES_FEED_DIRECTORY);
		    } catch (MalformedURLException e) {
		      throw new IOException("URL for sites feed is malformed.");
		    }
		  }  
	  
	  public static void printUserSites(WebmasterToolsService myService)
      throws ServiceException, IOException {
    try {
      System.out.println("Printing user's sites:");
      
      // Request the feed
      URL feedUrl = getSitesFeedUrl();
      SitesFeed sitesResultFeed = myService.getFeed(feedUrl, SitesFeed.class);
      //System.out.println(sitesResultFeed.getEntries());
      // Print the results
      for (SitesEntry entry : sitesResultFeed.getEntries()) {
        System.out.println("\t" + entry.getTitle().getPlainText());
        
        //System.out.println("Entry Links "+entry.getEntryLinks());
      }
    } catch (MalformedURLException e) {
      throw new IOException("URL for sites feed is malformed.");
    }
  }
	  public static void printSiteSettings(WebmasterToolsService myService)
      throws IOException, ServiceException {
    try {
      System.out.println("Printing site settings:");

      // Get the sites feed
      URL feedUrl = getSitesFeedUrl();
      SitesFeed sitesResultFeed = myService.getFeed(feedUrl, SitesFeed.class);
      for (SitesEntry entry : sitesResultFeed.getEntries()) {
        // Print site name and settings
        System.out.println("\t" + entry.getTitle().getPlainText());
        System.out.println("\t\tGeographic location:"
            + entry.getGeolocation());
        System.out.println("\t\tDesired Crawl Rate:"
            + entry.getCrawlRate());
        System.out.println("\t\tPreferred Domain Association:"
            + entry.getPreferredDomain());
        System.out.println("\t\tEnhanced Image Search:"
            + entry.getEnhancedImageSearch());
      }
    } catch (MalformedURLException e) {
      throw new IOException("URL for site URL is malformed.");
    }
  }
  
}
