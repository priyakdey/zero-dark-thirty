package com.priyakdey.design;

import java.util.*;

public class FileSharing {
    // https://leetcode.com/problems/design-a-file-sharing-system/

    // ID system
    private int currId;
    private final PriorityQueue<Integer> freeIds;

    // owner -> list of owned chunk
    private final Map<Integer, Set<Integer>> ownerMap;

    // chunk -> list of owners
    private final TreeSet<Integer>[] chunkMap;

    @SuppressWarnings("unchecked")
    public FileSharing(int m) {
        this.currId = 1;
        this.freeIds = new PriorityQueue<>();

        this.ownerMap = new HashMap<>();
        this.chunkMap = new TreeSet[m + 1];
    }

    public int join(List<Integer> ownedChunks) {
        int userId = -1;
        if (!freeIds.isEmpty()) {
            userId = freeIds.poll();
        } else {
            userId = currId;
            currId++;
        }

        ownerMap.put(userId, new HashSet<>(ownedChunks));
        for (int ownedChunk : ownedChunks) {
            if (this.chunkMap[ownedChunk] == null) {
                this.chunkMap[ownedChunk] = new TreeSet<>();
            }
            this.chunkMap[ownedChunk].add(userId);
        }

        return userId;
    }

    public void leave(int userID) {
        freeIds.add(userID);
        for (int ownedChunk : ownerMap.get(userID)) {
            this.chunkMap[ownedChunk].remove(userID);
            if (this.chunkMap[ownedChunk].isEmpty()) {
                this.chunkMap[ownedChunk] = null;
            }
        }
        this.ownerMap.remove(userID);
    }

    public List<Integer> request(int userID, int chunkID) {
        TreeSet<Integer> chunkOwners = this.chunkMap[chunkID];
        if (chunkOwners == null) {
            return List.of();
        }

        List<Integer> owners = new ArrayList<>(chunkOwners);

        this.chunkMap[chunkID].add(userID);
        this.ownerMap.get(userID).add(chunkID);

        return owners;
    }

}