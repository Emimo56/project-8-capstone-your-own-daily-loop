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

## Done