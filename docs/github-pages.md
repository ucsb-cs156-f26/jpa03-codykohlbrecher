# Github Pages (for backend only)

This repo contains Github Actions workflows (under the `.github/workflows` directory) that
can automatically publish documentation to a `gh-pages` branch, and publish documentation
for the code on the Github Pages site associated with the repo.

This file explains the necessary one-time setup steps to publish this documentation.

After that, the scripts should keep it automatically up-to-date, but if you need to manually regenerate it, the information
below explains how to do that.

When you first pull from this repo into another one, you might get a red X on the Github actions that publish the Github pages site;
following the instructions below should take care of that.

# Steps to setup Github Pages for this repo

## Step 1: Launch  `02-gh-pages-rebuild-part-1` action

Go to the `Actions` menu, and launch workflow `02-gh-pages-rebuild-part-1` as shown. You
 * select the job in the left hand navigation,
 * click on right where it says 'Run workflow'
 * then select `main` branch and click the green `Run Workflow` button **ONCE**.  **DO NOT CLICK IT TWICE**.

Note that it can take a long time for the display to update, and you may even need to refresh the page.  If you click the button twice (because you don't think it "heard you the first time"), it will just take longer and possible fail.
   
<img width="1122"  alt="Run Workflow: 02-gh-pages-rebuild-part-1" src="https://github.com/user-attachments/assets/866da876-456e-4de3-9960-31419dadf6a4" />


You now need to wait for this job to finish.

If and when job kick off job  `02-gh-pages-rebuild-part-1` finishes successfully:
* It will *automatically* kick off `04-gh-pages-rebuild-part-2`.
* Job `04-gh-pages-rebuild-part-2` will create a Github Pages site for the repo, with links to documentation for the Java code (in javadoc format) as well as links to the output of reports from jacoco (Code Coverage) and pitest (Mutation Coverage).

You'll need to click `04-gh-pages-rebuild-part-2` on on the left to see the status of job `04-gh-pages-rebuild-part-2`.  This is what a successful completion looks like:

<img width="1219" alt="image" src="https://github.com/user-attachments/assets/5e85aea7-d004-4ec4-9ddc-c41fb2c440d9" />

## What if the job fails?

It is not unusual for this job to fail (have a red X) the first time you run it.  

In this case, use the `Rerun Failed Jobs` option to just rerun the parts that failed.

<details markdown="1">
<summary markdown="1">
Click the triangle to read about how to re-run failed Github Actions
</summary>

Here's how to re-run failed Github Actions:

1. Go to the Github Actions tab of your repo
2. On the left side, in the list of workflows, if the one you are looking for is not listed, click `Show More Workflows`, as shown here:

<img width="317" alt="image" src="https://github.com/user-attachments/assets/5a1b6386-460a-484a-a89b-ec8251a81504">

3. On a failed workflow, if you click it, there should be a button like this at the upper right to re-run the failed workflow:

<img width="278" alt="image" src="https://github.com/user-attachments/assets/c9740071-4941-40ba-9948-7ed492f9aaeb">

Alternatively, find the button upper left that says "Run Workflow", click it, and then click the green `Run Workflow` button, as shown here:
   
<img width="414" alt="image" src="https://github.com/user-attachments/assets/aed9fbdc-5976-4997-9d36-640e5cb11cf0" />

</details>

## Step 2: Enable Github Pages

Enable Github Pages on the repo settings as shown below.

Select `Settings`, then `Pages`, then change:
 * `Source` to `Deploy from a branch`
 * `Branch` to `gh-pages` (if you don't see a `gh-pages` branch, you may need to wait for the jobs launched in step 1 to finish).
 * `Select Folder` should show `/ (root)`
  
As shown here:
   
<img width="606" alt="image" src="https://github.com/ucsb-cs156-m23/STARTER-jpa03/assets/1119017/4b762858-0b2d-42ad-a778-94680c50015a">

## Step 3: Set up Link on Main Repo Page

Return to the main page for the repo,  click on the gear at right, and click the box for Github Pages, as shown below
   
   ![add-gh-pages-link](https://user-images.githubusercontent.com/1119017/235330985-1d181d00-c775-4c93-aec1-87414467e0ed.gif)

## Step 4: Check link

Check that the link loads the Github Pages site.  

* At first, it might look like the version on the left; this means the page isn't in place yet.
* But eventually, it should look like the version on the right, but with your repo name in place of the one shown.  


<table>
<thead>
<tr>
<th>
If the Github Pages site is not yet fully deployed:
</th>
<th>
When the GitHub Pages site is fully deployed:
</th>
</tr>
</thead>
<tbody>
<tr>
<td>
<img width="500" alt="image" src="https://github.com/user-attachments/assets/2ceb5502-6b4b-4996-8e57-4002286e1fd4" />
</td>
<td>
<img width="500" alt="image" src="https://user-images.githubusercontent.com/1119017/235750584-2e66dc07-12b3-4593-a289-7e2f2b2060c2.png"></td>
</tr>
</tbody>
</table>

   
If it doesn't come up right away, check to see whether the  `02-gh-pages-rebuild-part-1` and `04-gh-pages-rebuild-part-2` actions have both finished.  You may find that it takes a minute or two for the page to become available, and another minute or two before the `javadoc`, `jacoco`, and `pitest` links for the main branch begin working; but within a few minutes, the page should load, and all of the links should work.

   
# What should it look like?

When it works, the top level page should look something like this. (There will be more to the page below what's shown here, but this is the only part we care about for now; the rest deals with pull requests, which will start talking about when we get to the team projects later.)

<img width="613" alt="image" src="https://github.com/user-attachments/assets/7cc89aea-a9bc-4058-988a-8f4988db0cad" />

There should be links for `javadoc`, `jacoco`, and `pitest`;  they should all work, and look something like what you see in the table below.

<table>
   <thead>
      <tr>
         <th>
            javadoc
         </th>
         <th>
            jacoco
         </th>
         <th>
            pitest
         </th>
      </tr>
   </thead>
   <tbody>
      <tr>
         <td>
            <img width="862" alt="image" src="https://github.com/user-attachments/assets/6383f288-4df2-467a-bce3-0ca29365749d" />
         </td>
         <td>
         <img width="864" alt="image" src="https://github.com/user-attachments/assets/25cfeaf8-3bd4-4d6f-bbd3-879db70f7bc0" />
         </td>
         <td>
         <img width="885" alt="image" src="https://github.com/user-attachments/assets/7e03672b-c713-4132-8de3-991c9e075a89" />
         </td>
      </tr>
   </tbody>
</table>

# Keeping the site up to date

If/when you add pull requests, reports will be generated for those as well on the later part of the page.

Note that the javadoc, jacoco, and pitest reports are only generated when there is a change to the backend code (either files under `src/` or the `pom.xml` file).

# Regenerating the site

If at any point, you want to rebuild the entire documentation site, you can run the GitHub Action `02-gh-pages-rebuild` again.

   
