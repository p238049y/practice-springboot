# SpringBeginnerAnswer# SpringBeginnerEasy

##アノテーションとは？
- 自動的にインスタンス化してくれる(newしてくれる)
- SpringにはDependency Injection(DI)という大事な仕組みがあり、インスタンス化したオブジェクトをいつでも使えるように保管している

## @Autowired
- @Autowiredは別のクラスを使えるようにしてくれるもの
- new呼び出さずにすむ

普通なら以下の通り
```Java
JdbcTemplate jdbcTemplate = new JdbcTemplate();
```
@Autowiredを使うと以下の通り
```Java
// 依存性の注入によりJdbcTemplateのインスタンスを自動で読み込んいる
@Autowired
public SampleController(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
}
```

## sql文について(セクション１−20)
- 以下は正しいSQLが走る
```sql
SELECT id, name, email " + "FROM inquiry WHERE id = 1
```
- 以下はエラーになる
```sql
SELECT id, name, email" + "FROM inquiry WHERE id = 1
```
→ emailの後にスペースを空けないと、SELECT id, name, emailFROM inquiry WHERE id = 1 となり、正しく実行されない