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

- 2026-09-24: `org.awaitility:awaitility` 4.2.2 -> 4.3.0 (minor bump, via an
  `awaitility.version` property override in `pom.xml`; awaitility is only
  reachable through the Spring Boot dependency-management BOM, not declared
  directly). Branch `claude/bump-awaitility` was created, the version bump
  was confirmed with `mvn dependency:tree` (resolves to 4.3.0) and all 12
  tests passed locally, but the `reviewer` agent returned **FAIL**, saying
  the `awaitility.version` property "is unused and not referenced in any
  dependency declaration." That reading looks mistaken — the property is
  consumed by the inherited `spring-boot-dependencies` BOM
  (`${awaitility.version}` in its `<dependencyManagement>`), and
  `dependency:tree` on the branch does show `awaitility:jar:4.3.0`. No PR
  was opened per the audit rules (FAIL blocks a PR). A human should
  double-check the branch and either open the PR manually or confirm the
  reviewer's concern is valid before this is retried.

## Done

- 2026-09-24: `org.yaml:snakeyaml` 2.4 -> 2.7 (minor bump, via a
  `snakeyaml.version` property override in `pom.xml`; snakeyaml is pulled
  in transitively through `spring-boot-starter-web`). Reviewer verdict:
  PASS. PR: https://github.com/Emimo56/project-8-capstone-your-own-daily-loop/pull/1
- 2026-09-24: `org.xmlunit:xmlunit-core` 2.10.3 -> 2.14.0 (minor bump, via
  an `xmlunit2.version` property override in `pom.xml`; xmlunit-core is
  pulled in transitively through `spring-boot-starter-test`). Reviewer
  verdict: PASS. PR: https://github.com/Emimo56/project-8-capstone-your-own-daily-loop/pull/2