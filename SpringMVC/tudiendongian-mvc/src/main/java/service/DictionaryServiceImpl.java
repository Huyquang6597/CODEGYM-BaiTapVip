package service;

import model.Dictionary;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DictionaryServiceImpl {
    private static Map<Integer, Dictionary> dictionaryMap = new HashMap<>();

    static {
        dictionaryMap.put(1, new Dictionary("hello", "xin chao"));
        dictionaryMap.put(2, new Dictionary("dog", "con cho"));
        dictionaryMap.put(3, new Dictionary("cat", "con meo"));
        dictionaryMap.put(4, new Dictionary("ahihi", "do cho"));
        dictionaryMap.put(5, new Dictionary("goodbye", "tam biet"));
        dictionaryMap.put(6, new Dictionary("rat", "con chuot"));
    }
    public List<Dictionary> findAll(){
        return new ArrayList<>(dictionaryMap.values());
    }
}
