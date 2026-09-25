---
name: dependency-audit
description: >-
  Runs the weekly dependency audit loop. Reads progress.md on the spine branch,
  finds outdated Maven dependencies on main, drafts one small version bump per
  branch, has each checked by the reviewer agent, opens PRs into main for what
  passes, and writes anything risky to progress.md for a human. Use for the
  scheduled weekly audit.
---

# Weekly dependency audit

You are the weekly dependency audit loop. Work through these steps in order.
Do not skip the progress file. It is your only memory between runs.

## 1. Read your memory first
- Run `git fetch origin`.
- Check out `claude/dep-audit-spine`. If it is missing, create it from
  `origin/main`, delete the "Blank template" comment line from `progress.md`,
  then commit and push.
- Open `progress.md`. Read "In progress" and "Open / needs a human".
- Do not redo anything already listed under "Done".

## 2. Find the work
- Check out `main` and run `git pull origin main`.
- Run `mvn versions:display-dependency-updates`.
- Pick at most 3 outdated dependencies not already in progress.md.

## 3. Work each candidate
- Create a fresh branch `claude/bump-<dependency-name>` from `main`.
- Change only that one version in `pom.xml`. Do not bundle changes.
- Stay on `claude/bump-<dependency-name>`. Invoke the reviewer agent and tell it:
  "Review branch claude/bump-<dependency-name> against main." Wait for its verdict.

## 4. Decide from the verdict
- PASS and a patch or minor bump: push the branch, then open a PR with
  base `main` and head `claude/bump-<dependency-name>`.
  Title it `chore: bump <name> to <version>`.
- FAIL, or a MAJOR version bump: open no PR. Note it for step 5 under
  "Open / needs a human": what you tried and why you stopped.

## 5. Update your memory last
- Check out `claude/dep-audit-spine`.
- In `progress.md`: put each PR opened under "Done" (date, dependency, PR link).
  Put each FAIL, major bump, or BOM-managed update under "Open / needs a human"
  (date, reason).
- Always add one line under "## Run log" at the end of progress.md,
  even if nothing was found:
  `YYYY-MM-DD HH:MM — checked N, new PRs N, new notes N, skipped (already noted) N`
- Commit and push `progress.md` to `claude/dep-audit-spine`. This is always the final step.

## Rules
- Never open more than 3 PRs in one run.
- Never open a PR from `claude/dep-audit-spine`. It only stores progress.md.
- Never change `main` directly. Never merge anything. Only `claude/*` branches.
- Never write `progress.md` on a bump branch. Only on `claude/dep-audit-spine`.
- When in doubt, escalate to "needs a human".
- Only bump dependencies declared directly in `pom.xml` with their own version.
    Do not override versions managed by the Spring Boot parent/BOM. List those
    under "Open / needs a human" instead.
- Ignore pre-release versions (-M, -RC, -SNAPSHOT, alpha, beta).
- If the newest version is a pre-release, find the newest STABLE version and
  report that instead. A stable major bump goes under "Open / needs a human".