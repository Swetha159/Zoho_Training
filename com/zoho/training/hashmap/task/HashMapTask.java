package com.zoho.training.hashmap.task;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.zoho.training.exceptions.TaskException;
import com.zoho.training.utility.Util;

public class HashMapTask 
{
	public <T,E> Map<T,E> getMap()
	{
		return new HashMap<T,E>( );
	}
	public <T,E> void addKeyAndValue(Map<T,E> map,T key, E value) throws TaskException
	{
		Util.validateInput(map,"Map");
		map.put(key,value);
	}
	public <T,E> boolean keyExists(Map<T,E> map,T key) throws TaskException
	{
		Util.validateInput(map,"Map");
		return map.containsKey(key);
	}
	public <T,E> boolean valueExists(Map<T,E> map,E value) throws TaskException
	{
		Util.validateInput(map,"Map");
		return map.containsValue(value);
	}
	public <T,E> E getValue(Map<T,E> map,T key) throws TaskException
	{
		Util.validateInput(map,"Map");
		return map.get(key);
	}
	public <T,E> E getValueOrDefaultValue(Map<T,E> map,T key ,E defaultValue) throws TaskException
	{
		Util.validateInput(map,"Map");
		return map.getOrDefault(key,defaultValue);
	}
	public <T,E> void removeKey(Map<T,E> map,T key) throws TaskException
	{
		Util.validateInput(map,"Map");
		map.remove(key);
	}
	public <T,E> void removeKeyIfValueMatches(Map<T,E> map,T key,E value) throws TaskException
	{
		Util.validateInput(map,"Map");
		map.remove(key,value);
	}
	public <T,E> void replaceValue(Map<T,E> map,T key ,E value) throws TaskException
	{
		Util.validateInput(map,"Map");
		map.replace(key,value);
	}
	public <T,E> void replaceValueIfValueMatches(Map<T,E> map,T key ,E value ,E  newValue) throws TaskException
	{
		Util.validateInput(map,"Map");
		map.replace(key,value,newValue);
	}
	public <T,E> void addMap(Map<T,E> firstMap ,Map<T,E> secondMap) throws TaskException
	{
		Util.validateInput(firstMap,"firstMap");
		Util.validateInput(secondMap,"secondMap");
		firstMap.putAll(secondMap);
	}
	public <T,E> Set<Map.Entry<T,E>> getEntrySet(Map<T,E> map) throws TaskException
	{	
		Util.validateInput(map,"Map");
		return map.entrySet();
	}
	public  <T,E> T getKeyFromEntry(Map.Entry<T,E> entry) throws TaskException
	{
		Util.validateInput(entry,"Entry");
		return entry.getKey();
	}
	public  <T,E> E getValueFromEntry(Map.Entry<T,E> entry) throws TaskException
	{
		Util.validateInput(entry,"Entry");
		return entry.getValue();
	}
	public <T,E> void removeAllEntries(Map<T,E> map) throws TaskException
	{
		Util.validateInput(map,"Map");
		map.clear();
	}
	public <T,E> Set<T> getKeySet(Map<T,E> map)throws TaskException
	{
		Util.validateInput(map,"Map");
		return map.keySet();
	}

}