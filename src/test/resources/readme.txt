Для запуска тестов, в vm option, надо добавить параметры

-Dlogback.configurationFile=file:/// *** /logback.xml
-Dplatform-config=file:/// *** /platform-config.properties
-Dnode.id=hmlk-vhj-hjhj
-Dconfig-store.disable=true
-Djndi-store.disable=true
-Djboss.http.port=8088
-Dconsole.encoding=UTF-8
-Dsun.jnu.encoding=UTF-8
-Dconfig-test=src/main/resources/config/local.properties

Узнав в -Dlogback.configurationFile и -Dplatform-config пути до соответствующих файлов.