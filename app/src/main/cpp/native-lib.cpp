#include <jni.h>
#include <string>
#include "map"

using namespace std;


map<string, string> c_map{{"Ura",  "111"},
                          {"Vova", "222"},
                          {"Dima", "333"}};

string change(jstring old, JNIEnv *env) {

    jboolean isCopy;
    const char *convertedValue = (env)->GetStringUTFChars(old, &isCopy);
    string nameString = convertedValue;
    return nameString;
}

extern "C"
JNIEXPORT jstring JNICALL
Java_com_example_pepa_ContactsActivity_getAllContact(JNIEnv *env, jobject thiz) {

    string otvet;
    for (auto it = c_map.begin(); it != c_map.end(); it++) {  // выводим их
        otvet += it->first;
        otvet += " ";

    }
    return env->NewStringUTF(otvet.c_str());
}
extern "C"
JNIEXPORT jstring JNICALL
Java_com_example_pepa_Contact_takeContact(JNIEnv *env, jobject thiz, jstring name) {
    string strName = change(name, env);
    string number = c_map.find(strName)->second;

    return env->NewStringUTF(number.c_str());
}
extern "C"
JNIEXPORT void JNICALL
Java_com_example_pepa_addContact_saveContact(JNIEnv *env, jobject thiz, jstring name,
                                             jstring number) {
    string strName = change(name, env);
    string strNumber = change(number, env);
    c_map.insert(pair<string, string>(strName, strNumber));

}
extern "C"
JNIEXPORT jstring JNICALL
Java_com_example_pepa_findContact_findNumber(JNIEnv *env, jobject thiz, jstring name) {
    string strName = change(name, env);
    string number = c_map.find(strName)->second;

    return env->NewStringUTF(number.c_str());
}
extern "C"
JNIEXPORT jboolean JNICALL
Java_com_example_pepa_findContact_checkContact(JNIEnv *env, jobject thiz, jstring name) {
    string strName = change(name, env);
    jboolean otvet = false;
    if (c_map.count(strName) != 0) { otvet = true; }
    return otvet;
}