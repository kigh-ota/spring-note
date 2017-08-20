# Note

## Domain Models

```
[E]Note
  [V]Title
  [V]Body
[V]Tag
  [V]Name
[E]User
```

## Misc

### PostgreSQL on macOS

#### Start

```bash
$ brew services start postgresql
#  or
$ pg_ctl -D /usr/local/var/postgres -l logfile start
```

#### Initialize

```bash
$ initdb /usr/local/var/postgres -E utf8
```