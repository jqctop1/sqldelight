package app.cash.sqldelight.driver.native

import app.cash.sqldelight.db.QueryResult
import app.cash.sqldelight.db.SqlSchema
import co.touchlab.sqliter.DatabaseConfiguration


fun createOhosSqliteDriver(
  schema: SqlSchema<QueryResult.Value<Unit>>,
  name: String,
  onConfiguration: ((DatabaseConfiguration) -> DatabaseConfiguration) ?= null
) : NativeSqliteDriver {
  return NativeSqliteDriver(
    schema = schema,
    name = name,
    onConfiguration = {
      onConfiguration?.invoke(it) ?: it
    }
  )
}
