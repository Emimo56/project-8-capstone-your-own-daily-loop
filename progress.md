# Progress

## In progress

## Open / needs a human

- 2026-09-24: `org.springframework.boot:spring-boot-starter-parent` (and the
  dependencies it manages: `spring-boot-starter-web`,
  `spring-boot-starter-test`, `spring-boot-maven-plugin`) is the only
  outdated dependency `mvn versions:display-dependency-updates` /
  `versions:display-parent-updates` found. Its only available update is
  3.5.5 -> 4.2.0-M2 — a MAJOR version bump (3.x -> 4.x) to a pre-release
  milestone, not a GA release. No patch or minor update is available on the
  3.5.x line. Per the audit rules, major bumps are not opened as PRs
  automatically, so no branch was created and no PR was opened this run.
  A human should decide whether/when to move to Spring Boot 4 once it
  reaches GA.

- 2026-09-24: `org.awaitility:awaitility` 4.2.2 -> 4.3.0 is managed by the
  Spring Boot BOM. HUMAN DECISION: do not override BOM-managed versions.
  Awaitility will move up when Spring Boot is upgraded.

- 2026-09-25: Re-ran the audit on current `main`. `pom.xml` declares no
  dependency with its own version (only the `spring-boot-starter-parent`
  and two starters that inherit their versions from it), so there are no
  directly-declared dependencies eligible to bump under the audit rules.
  `mvn versions:display-dependency-updates` / `versions:display-parent-updates`
  confirm the only outdated items are still (a) the Spring Boot parent/BOM
  itself, whose only update is the 4.2.0-M2 pre-release milestone (major +
  pre-release, excluded), and (b) dozens of transitive/BOM-managed
  dependencies (Jackson, Logback, Awaitility, etc.), which are not to be
  overridden. No branches created, no PRs opened this run. Same conclusion
  holds until Spring Boot ships a 3.5.x patch/minor or a GA 4.x release.

## Done

## Run log