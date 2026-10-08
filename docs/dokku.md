# Dokku Setup

These instructions explain how to deploy this app on dokku with a postgres database, and OAuth logins.

As you follow these instructions, don't just blindly copy and paste:
* <tt><i>yourGithubLogin</i></tt> should be changed to your github login
* <tt><i>yourEmail</i></tt> should be changed to your email.

The steps below should be done *strictly in this order*. If you try them in a different order, things may not work properly.

1. Configure the app on localhost using a `.env` file as explained in [`/docs/oauth.md`](/docs/oauth.md), and have the `.env` file open in an editor so that the values are handy.
2. Create a new dokku app with <tt>dokku apps:create jpa03-<i>yourGithubLogin</i></tt>
3. Set the app to ones that keeps the git directotry around:
   <tt>dokku git:set jpa03-<i>yourGithubLogin</i> keep-git-dir true</tt>
4. Use these commands to set up the configuration variables for the app.  Replace *value-from-env* in each case with the correct value from the .env file you configured for localhost:<br />
   <tt>dokku config:set --no-restart jpa03-<i>yourGithubLogin</i> PRODUCTION=true</tt><br />
   <tt>dokku config:set --no-restart jpa03-<i>yourGithubLogin</i> GOOGLE_CLIENT_ID=<i>value-from-env</i></tt><br />
   <tt>dokku config:set --no-restart jpa03-<i>yourGithubLogin</i> GOOGLE_CLIENT_SECRET=<i>value-from-env</i></tt><br />
   <tt>dokku config:set --no-restart jpa03-<i>yourGithubLogin</i> ADMIN_EMAILS=<i>value-from-env</i></tt><br />
5. Deploy and link a postgres database using<br />
   <tt>dokku postgres:create jpa03-<i>yourGithubLogin</i>-db</tt><br />
   <tt>dokku postgres:link jpa03-<i>yourGithubLogin</i>-db jpa03-<i>yourGithubLogin</i> </tt> <br />

   Note that when you do this, you may get the message:
   
   <tt>App image (dokku/jpa03-yourGithubLogin</i>:latest) not found</tt>

   This is normal; it signifies that we have not yet uploaded any *code* for this application,
   so there's nothing to actually *run* yet.
   

6. Build the app with regular `http` using the commands.  This will deploy an http only version of the app. When these commands complete, *you will still not be able to login yet, but you should be able to access the home page over `http`*:<br />
   <tt>dokku git:sync jpa03-<i>yourGithubLogin</i> https://github.com/ucsb-cs156-f26/jpa03-<i>yourGithubLogin</i> main</tt><br />
   <tt>dokku ps:rebuild jpa03-<i>yourGithubLogin</i></tt><br />
7. Now deploy https (encrypting) with these commands.
   This will deploy an https  version of the app.
   When these commands complete, *you should be able to login with OAuth*:<br />
   <tt>dokku letsencrypt:set jpa03-<i>yourGithubLogin</i> email <i>yourEmail</i>@ucsb.edu</tt><br />
   <tt>dokku letsencrypt:enable jpa03-<i>yourGithubLogin</i></tt>
   <tt>dokku ps:rebuild jpa03-<i>yourGithubLogin</i></tt><br />

For troubleshooting advice with OAuth, this page may help:

* <https://ucsb-cs156.github.io/topics/oauth/oauth_troubleshooting.html>
